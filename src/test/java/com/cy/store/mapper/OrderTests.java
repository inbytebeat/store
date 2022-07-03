package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.tree.VoidDescriptor;

import java.sql.Time;
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
public class OrderTests
{
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder()
    {
        Order order = new Order();
        order.setUid(31);
        order.setRecvName("xty");
        order.setRecvPhone("1519986");
        order.setRecvCity("石河子");
        order.setRecvArea("石河子大学");
        order.setRecvAddress("男生南区11楼");
        order.setTotalPrice(15L);
        order.setStatus(1);
        Integer rows = orderMapper.insertOrder(order);
        System.out.println(rows);
    }

    @Test
    public void insertOrderItem()
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(1);
        orderItem.setTitle("小电脑");
        orderItem.setId(1);
        orderItem.setNum(2);
        Integer rows = orderMapper.insertOrderItem(orderItem);
        System.out.println(rows);
    }


}