package com.cy.store.service.impl;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.CartDeniedException;
import com.cy.store.service.ex.CartNotFoundException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UpdateException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-29 11:03
 * @Description:
 */
@Service
public class CartService implements ICartService
{
    /** 购物车的业务层依赖于购物车的持久层以及商品的持久层*/
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username)
    {
        Cart result = cartMapper.selectByUidAndPid(uid, pid);
        Date date = new Date();
        if(result == null)
        {//表示该用户的购物车中还没有加入过该商品的数据，则进行插入该条商品数据的操作
            Cart cart = new Cart();
            cart.setCreatedUser(username);
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //补全商品价格
            Product product = productMapper.findByIdProduct(pid);
            cart.setPrice(product.getPrice());
            //补全日志信息
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);
            Integer rows = cartMapper.insert(cart);
            if(rows != 1)
            {
                throw new InsertException("添加购物车数据时，产生未知的异常");
            }
        }
        else
        {
            //在原有购物车基础上商品数量进行添加
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumber(result.getCid(), num, username, date);
            if(rows != 1)
            {
                throw new UpdateException("更新购物车数据时，产生未知异常");
            }
        }
    }

    @Override
    public List<CartVO> getByUid(Integer uid)
    {
        List<CartVO> result = cartMapper.findByUid(uid);
        return result;
    }

    @Override
    public List<CartVO> getByCids(Integer uid, Integer[] cids)
    {
        List<CartVO> result = cartMapper.findOvByCid(cids);
        if(result.size() == 0)
        {
            return result;
        }
        System.out.println(result.size());
        Iterator<CartVO> iterator = result.iterator();
        while (iterator.hasNext())
        {
            CartVO cartVO = iterator.next();
            if(cartVO.getUid() != uid)
            {
                result.remove(cartVO);
            }
        }
        return result;
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String modifiedUser)
    {
        Cart cart = cartMapper.findByCid(cid);
        if(cart == null)
        {
            throw new CartNotFoundException("购物车数据不存在");
        }
        if(cart.getUid() != uid)
        {
            throw new CartDeniedException("非法的购物车数据");
        }
        Integer num  = cart.getNum() + 1;
        Integer integer = cartMapper.updateNumber(cid, num, modifiedUser, new Date());
        if(integer != 1)
        {
            throw new UpdateException("购物车商品数量添加失败");
        }
        return num;
    }

    @Override
    public Integer subNum(Integer cid, Integer uid, String modifiedUser)
    {
        Cart cart = cartMapper.findByCid(cid);
        if(cart == null)
        {
            throw new CartNotFoundException("购物车数据不存在");
        }
        if(cart.getUid() != uid)
        {
            throw new CartDeniedException("非法的购物车数据");
        }
        if(cart.getNum() == 0)
        {
            return 0;
        }

        Integer num  = cart.getNum() - 1;
        Integer integer = cartMapper.updateNumber(cid, num, modifiedUser, new Date());
        if(integer != 1)
        {
            throw new UpdateException("购物车商品数量添加失败");
        }
        return num;
    }

}