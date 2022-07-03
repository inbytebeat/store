package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import sun.plugin.javascript.navig.Link;

import java.util.Date;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:04
 * @Description: 收货地址持久层
 */
public interface AddressMapper
{
    /**
     * 插入用户的收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户id统计其收货地址的总数
     * @param uid 被查询的用户的uid
     * @return 返回当前用户的收货地址数量
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的uid 查询其下所有的收货地址
     * @param uid
     * @return
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据地址的aid和uid查询地址记录，判断改地址是否存在
     * @param aid 地址的id
     * @param uid 用户的id
     * @return 地址对象
     */
    Address selectByAid(@Param("aid") Integer aid,@Param("uid") Integer uid);

    /**
     * 在将某条地址记录设置为默认时，现将所有的记录设置为非默认
     */
    Integer setNoDefault(Integer uid);

    /**
     * 将指定的地址记录设置为默认
     * @param aid 指定的地址id
     */
    Integer setDefault(@Param("aid") Integer aid, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

    /**
     * 删除指定的地址记录
     * @param aid 地址编号
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询用户最近修改的那条地址记录
     * @param uid 用户uid
     * @return 地址集合
     */
    Address orderByCreateTime(Integer uid);


}
