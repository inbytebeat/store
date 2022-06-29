package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
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
public class CartTests
{
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert()
    {
        Cart cart = new Cart();
        cart.setUid(33);
        cart.setPid(10000019);
        cart.setPrice(4899L);
        cart.setNum(2);
        cart.setCreatedUser("小帅哥");
        cart.setCreatedTime(new Date());
        Integer row = cartMapper.insert(cart);
        System.out.println(row);
    }

    @Test
    public void update()
    {
        Integer rows = cartMapper.updateNumber(2, 4, "小帅哥", new Date());
        System.out.println(rows);
    }

    @Test
    public void select()
    {
        Cart cart = cartMapper.selectByUidAndPid(33, 10000019);
        System.out.println(cart);
    }

    @Test
    public void selectByUid()
    {
        List<CartVO> result = cartMapper.findByUid(33);
        for (CartVO item : result) {
            System.out.println(item);
        }
    }


}