package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:04
 * @Description: 购物车实体类
 */
public interface CartMapper
{
    /**
     * 插入购物车数据
     * @param cart 购物车对象
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车中的商品数据
     * @param cid 购物车编号
     * @param num 商品数量
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumber(@Param("cid") Integer cid,@Param("num") Integer num,@Param("modifiedUser") String modifiedUser,@Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和商品id查询用户购物车中的数据
     * @param uid 用户id
     * @param pid 商品id
     * @return 指定用户的购物车中的指定商品数据
     */
    Cart selectByUidAndPid(@Param("uid") Integer uid,@Param("pid") Integer pid);
}