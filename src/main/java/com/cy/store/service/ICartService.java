package com.cy.store.service;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.Calendar;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-29 10:59
 * @Description: 购物车业务层接口
 */
public interface ICartService
{
    /**
     * 添加购物车记录
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 商品数量
     * @param username 用户名称
     */
    void addToCart(Integer uid,Integer pid,Integer amount,String username);

    /**
     * 查询用户购物车记录
     * @param uid 用户id
     * @return 用户的购物车商品信息
     */
    List<CartVO> getByUid(Integer uid);

    /**
     * 增加用户购物车商品的数量 +1
     * @param cid 购物车id
     * @param uid 用户id
     * @param modifiedUser 修改者
     * @return 返回增加数量后当前购物车中的该条商品的当前数量
     */
    Integer addNum(Integer cid,Integer uid,String modifiedUser);

    /**
     * 减少用户购物车中商品的数量 -1
     * @param cid 购物车id
     * @param uid 用户id
     * @param modifiedUser 修改者
     * @return
     */
    Integer subNum(Integer cid,Integer uid,String modifiedUser);

    /**
     * 查询购物车中被选中的商品的信息
     * @param uid 用户id
     * @param cid 购物车id
     * @return 购物车中被选中的商品的信息
     */
    List<CartVO> getByCids(Integer uid,Integer[] cid);


}
