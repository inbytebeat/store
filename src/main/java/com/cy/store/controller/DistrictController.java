package com.cy.store.controller;

import com.cy.store.entity.District;
import com.cy.store.service.impl.DistrictServiceImpl;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-27 11:58
 * @Description: 获取省市区列表-控制层
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController
{
    @Autowired
    private DistrictServiceImpl districtService;

    //将district开头的请求都拦截到getByParent()方法，之所以地址使用了列表，使用户在输入districts之后就可以跳转到地址页面
    @RequestMapping({"/ ",""})
    public JsonResult<List<District>> getByParent(String parent)
    {
        List<District> districts = districtService.getParent(parent);
        return new JsonResult<>(SAVE_OK,districts);
    }
}