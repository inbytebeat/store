package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.rmi.server.UID;
import java.util.List;

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

    @RequestMapping({"/",""})
    public JsonResult<List<CartVO>> selectByUid(HttpSession session)
    {
        List<CartVO> byUid = cartService.getByUid(getUidFromSession(session));
        return new JsonResult<>(SAVE_OK,byUid);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addProductNum(@PathVariable("cid") Integer cid,HttpSession session)
    {
        System.out.println(cid);
        Integer data = cartService.addNum(cid, getUidFromSession(session), getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK,data);
    }

    @RequestMapping("{cid}/num/sub")
    public JsonResult<Integer> subProductNum(@PathVariable("cid") Integer cid,HttpSession session)
    {
        System.out.println(cid);
        Integer data = cartService.subNum(cid, getUidFromSession(session), getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK,data);
    }

    @RequestMapping("lists")
    public JsonResult<List<CartVO>> selectByCid(Integer[] cids,HttpSession session)
    {
        List<CartVO> carts = cartService.getByCids(getUidFromSession(session), cids);
        return new JsonResult<>(SAVE_OK,carts);
    }
}