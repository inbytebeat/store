package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 16:13
 * @Description: 用户模块的持久层接口
 */
public interface UserMapper
{
    /**
     * 注册新用户
     * @param user 封装好的用户数据
     * @return 受影响的行数 可以用来判断是否执行成功
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户,用于注册检查用户名是否被占用，以及登录时持久层先进行用户名的查询，如果有该用户，则密码的校验放在业务层中
     * @param userName
     * @return 如果找到对应用户，则返回对应用户的信息，如果没有找到则返回null
     */
    User findByUserName(String userName);


    /**
     *
     * @param uid 待修改密码的用户uid
     * @param password 新的用户密码
     * @param modifiedUser 修改密码者
     * @param modifiedTime 修改密码时间
     * @return 返回受影响的行数
     */
    Integer changePassword(@Param("uid") Integer uid, @Param("password") String password, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);


    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 如果找到则返回查询的对象，反之返回null
     */
    User findUserByUid(Integer uid);

    /***
     * 更新用户的数据信息
      * @param user 用户的数据
     * @return 返回受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * @param(用于将参数值，传递给对应xml文件的sql语句中的同名占位符，比如@Param("uid) 就是给xml文件中的 uid = #{uid} 的这个#{uid}赋值，从而将参数值写入sql语句中的那个对应的?)
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUidInteger(@Param("uid") Integer uid,@Param("avatar") String avatar,@Param("modifiedUser") String modifiedUser,
                                     @Param("modifiedTime") Date modifiedTime);





}
