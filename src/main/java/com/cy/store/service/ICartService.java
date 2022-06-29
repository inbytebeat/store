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
}
