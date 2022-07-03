package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.service.impl.OrderServiceImpl;
import com.cy.store.util.JsonResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-07-03 15:33
 * @Description: 订单模块的控制层
 */
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController
{
    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("create")
    public JsonResult<Order> insertOrder(Integer aid, Integer[] cids, HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        String username = getUserNameFromSession(session);
        Order data = orderService.createOrder(aid, uid, username, cids);
        return new JsonResult<>(SAVE_OK,data);
    }
}