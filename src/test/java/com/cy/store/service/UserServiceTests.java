package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class UserServiceTests
{
    @Autowired
    private IUserService userService;

    @Test
    public void reg()
    {
        try
        {
            User user = new User();
            user.setUsername("upTest");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e)
        {
            //获取异常类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的提示信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login()
    {
        User user = new User();
        user.setUsername("gg");
        user.setPassword("123");
        userService.login(user.getUsername(), user.getPassword());
        System.out.println(user);
    }

    @Test
    public void ChangePassword()
    {
        userService.ChangePassword(33,"1234","123","xty");
    }


    @Test
    public void getUserByUid()
    {
        System.out.println(userService.getUserByUid(31));
    }

    @Test
    public void updateUserInfo()
    {
        User info = new User();
        info.setPhone("11111");
        info.setEmail("1151@qq.com");
        info.setGender(0);
        userService.changUserInfo(31,"test2",info);
    }

    @Test
    public void updateAvatar()
    {
        userService.changeAvatar(31,"/update/avatarjjjjjj.png","xty");
    }
}