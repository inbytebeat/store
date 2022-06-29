package com.cy.store.mapper;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 17:18
 * @Description:
 */
//表示标注当前的类是一个测试类，不会随同当前的项目一起打包
@SpringBootTest
//@RunWith 表示启动这个单元测试类，否则不能够运行，且必须传递SpringRunner.class
@RunWith(SpringRunner.class)
public class UserMapperTests
{
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法:可以独立运行，不用启动项目 可以用于做单元测试，
     * 必须满足
     * 1.必须被@Test修饰
     * 2.返回值必须是void
     * 3.方法的参数类型不指定任何类型
     * 4.方法的访问修饰符必须是public
     */

    @Test
    public void insert()
    {
        User user = new User();
        user.setUsername("hh333");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUserName()
    {
        User user = userMapper.findByUserName("hh222");
        System.out.println(user);
    }

    @Test
    public void findByUserUid()
    {
        User user = userMapper.findUserByUid(31);
        System.out.println(user);
    }

    @Test
    public void changPasswordByUid()
    {
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        Integer result = userMapper.changePassword(1,"1003","xty", date);
        System.out.println(result);
    }

    @Test
    public void updateUserInform()
    {
        User user = new User();
        user.setUid(31);
        user.setPhone("15199869676");
        user.setEmail("15199869676@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid()
    {
        Integer rows = userMapper.updateAvatarByUidInteger(31, "/upload/avatar.png", "xty", new Date());
        System.out.println(rows);
    }



}