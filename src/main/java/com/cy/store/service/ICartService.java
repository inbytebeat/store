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
    void addToCart(Integer uid,Integer pid,Integer amount,String username);

    List<CartVO> getByUid(Integer uid);

    List<CartVO> getByCids(Integer uid,Integer[] cids);

    /**
     * 增加用户购物车商品的数量
     * @param cid 购物车id
     * @param uid 用户id
     * @param modifiedUser 修改者
     * @return 返回增加数量后当前购物车中的该条商品的当前数量
     */
    Integer addNum(Integer cid,Integer uid,String modifiedUser);


    Integer subNum(Integer cid,Integer uid,String modifiedUser);


}
