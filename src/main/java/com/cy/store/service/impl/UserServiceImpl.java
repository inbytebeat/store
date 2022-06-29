package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.UUID;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:41
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user)
    {
        User isReg = userMapper.findByUserName(user.getUsername());
        if (isReg != null)
        {
            throw new  UsernameDuplicatedException("该用户名被占用");
        }
        //在获取用户输入的密码录入数据库之前先加密处理：以MD5算法的形式，该算法忽略了原有密码的安全性
        //(盐值 + password + 盐值) ：连续进行三次该操作 盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        String newPassword = getMd5Password(oldPassword, salt);
        //将加密之后的密码重新设置到密码中
        user.setPassword(newPassword);
        //同时记录下此刻系统生成的盐值 之后用户登录时就可以通过该盐值与输入密码进行结合通过算法生成的结果判断密码是否正确
        user.setSalt(salt);
        //在用户成功注册之后，进行必要信息的补全
        //is_delete设置为0
        user.setIsDelete(0);
        //补全四个日志字段信息
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());

        Integer rows = userMapper.insert(user);
        if(rows != 1)
        {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String userName, String passWord)
    {
        User result = userMapper.findByUserName(userName);

        if(result == null)
        {
            throw new UserNotFoundException("该用户不存在");
        }

        //在控制层获取到用户的输入密码后按照md5算法规则进行加密，将结果与数据库中的密码进行比较
        String truePassWord = result.getPassword();
        if(!getMd5Password(passWord,result.getSalt()).equals(truePassWord))
        {
            throw new PasswordNotFoundException("用户密码错误");
        }

        //判断is_delete是否为1来判断该条用户数据是否被注销或者是被删除,如果为1表示被删除或者是注销
        if(result.getIsDelete() == 1)
        {
            throw new UserNotFoundException("该用户已被注销");
        }

        //TODO 该user对象用于传输页面中的常用数据，减少一次传输数据的数据量，这是调优
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);
        user.setUid(result.getUid());
        user.setAvatar(result.getAvatar());
        //如果未发生异常 则返回用户数据
        return user;
    }

    @Override
    public void ChangePassword(Integer uid, String password, String newPassword, String userName)
    {
        User user = userMapper.findUserByUid(uid);

        if(user == null || user.getIsDelete() == 1)
        {
            throw new UserNotFoundException("该用户不存在 或已被注销");
        }
        String pass = getMd5Password(password,user.getSalt());
        if(!pass.equals(user.getPassword()))
        {
            throw new PasswordNotFoundException("密码错误 无法修改密码");
        }

        String newMd5Password = getMd5Password(newPassword, user.getSalt());
        Integer rows = userMapper.changePassword(user.getUid(), newMd5Password, userName, new Date());
        System.out.println("修改成功");

        if(rows != 1)
        {
            throw new UpdateException("修改时异常");
        }

    }

    @Override
    public User getUserByUid(Integer uid)
    {
        User user = userMapper.findUserByUid(uid);
        if(user == null || user.getIsDelete() == 1)
            throw new UserNotFoundException("该用户不存在");
        //这里做了一个优化，只将需要的数据传递给前台，减少数据对象的大小
        User data = new User();
        data.setUsername(user.getUsername());
        data.setEmail(user.getEmail());
        data.setPhone(user.getPhone());
        data.setGender(user.getGender());
        return data;
    }

    //由于前端用户在修改用户信息的时候，表单中的数据只有phone,email,gender，我们还需要手动将uid和username封装到user对象中
    @Override
    public void changUserInfo(Integer uid, String username, User user)
    {
        User result = userMapper.findUserByUid(uid);
        if(result == null || result.getIsDelete() == 1)
        {
            throw new UserNotFoundException("该用户不存在 修改失败");
        }

        //封装数据到user对象中
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if(rows != 1)
            throw new UpdateException("更新数据时产生未知的异常");
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username)
    {
        User result = userMapper.findUserByUid(uid);
        if(result == null || result.getIsDelete() == 1)
        {
            throw new UserNotFoundException("该用户不存在 无法上传头像");
        }

        Integer rows = userMapper.updateAvatarByUidInteger(uid, avatar, username,new Date());
        if(rows != 1)
        {
            throw new UpdateException("更新用户头像时产生未知异常");
        }
    }

    //定义一个MD5算法的加密
    private String getMd5Password(String password,String salt)
    {
        //MD5算法的加密处理
        for (int i = 0; i < 3; i++)
        {
            password = DigestUtils.md5DigestAsHex((salt + password  + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}