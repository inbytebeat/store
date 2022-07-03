package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:39
 * @Description: 订单模块业务层接口
 */
public interface IOrderService
{
    Order createOrder(@Param("aid") Integer aid,@Param("uid") Integer uid,@Param("username") String username,@Param("cids") Integer[] cids);
}
