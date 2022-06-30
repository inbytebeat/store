package com.cy.store.service;

import com.cy.store.entity.Cart;
import com.cy.store.mapper.CartMapper;
import com.cy.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

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
public class CartServiceTests
{
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart()
    {
        cartService.addToCart(33,10000013,3,"大帅比");
    }

    @Test
    public void select()
    {
        Integer[] list = new Integer[]{1,2,4};
        List<CartVO> byCids = cartService.getByCids(33, list);
        System.out.println(byCids);
    }

    @Test
    public void add()
    {
        Integer integer = cartService.addNum(7, 31, "test2");
        System.out.println(integer);
    }

}