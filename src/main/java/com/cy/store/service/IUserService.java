package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:39
 * @Description: 用户模块业务层接口
 */
public interface IUserService
{
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录方法
     * @param userName 用户输入的用户名
     * @param password 用户输入的密码
     * @return 之所以返回User 是可以获取登陆成功后的用户信息,如果没有则返回null
     */
    User login(String userName,String password);


    /**
     * 修改用户的密码
     * @param uid 用户id
     * @param password 用户秘密
     * @param newPassWord 用户的新密码
     * @param userName 用户名
     */
    void ChangePassword(Integer uid, String password, String newPassWord, String userName);

    /**
     * 根据用户id查询用户数据
     * @param uid 用户uid
     * @return 用户数据
     */
    User getUserByUid(Integer uid);

    /**
     * 修改用户信息
     * @param uid 用户的uid
     * @param username 用户名
     * @param user 即将修改数据的用户对象
     */
    void changUserInfo(Integer uid, String username, User user);

    /**
     * 更新用户的头像
     * @param uid 用户的uid
     * @param avatar 用户头像的保存路径
     * @param username 用户名
     */
    void changeAvatar(Integer uid,String avatar,String username);




}
