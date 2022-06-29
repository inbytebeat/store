package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.Product;
import com.cy.store.entity.User;
import com.cy.store.service.IProductService;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 21:10
 * @Description: 商品的控制类
 */
//RestController=controller+responseBody
@RestController
//RequestMapping设置当controller收到users下的所有请求时，都会被UserController所接管
@RequestMapping("products")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
   public JsonResult<List<Product>> hotList()
    {
        List<Product> data =  productService.selectHotProduct();
        return new JsonResult<List<Product>>(SAVE_OK,data);
    }

    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id)
    {
        Product data = productService.getById(id);
        return new JsonResult<>(SAVE_OK,data);
    }



}