package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.rmi.server.UID;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-29 12:12
 * @Description: 购物车控制层
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController
{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session)
    {
        cartService.addToCart(getUidFromSession(session),pid,amount,getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK);
    }
}