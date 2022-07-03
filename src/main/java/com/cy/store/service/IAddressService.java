package com.cy.store.service;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:38
 * @Description:
 */
public interface IAddressService
{
    void addNewAddress(String username, Integer uid, Address address);

    List<Address> selectAddressByUid(Integer uid);

    /**
     * 设置某条地址为用户的默认地址
     * @param aid 地址编号
     * @param uid 用户编号
     * @param username 修改者，即登录的用户
     */
    void setDefault(Integer aid,Integer uid,String username);

    /**
     * 删除用户指定的收货地址
     * @param aid 地址编号
     * @param uid 用户编号
     * @param username 用户名
     */
    void deleteAddress(Integer aid,Integer uid,String username);

    /**
     * 根据aid和用户id获取指定地址记录
     * @param aid 地址编号
     * @param uid 用户编号
     * @return 返回地址对象
     */
    Address getById(@Param("aid") Integer aid,@Param("uid") Integer uid);
}
