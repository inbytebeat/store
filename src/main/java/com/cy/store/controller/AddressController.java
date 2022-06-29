package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.io.File;
import java.io.IOException;
import java.rmi.activation.ActivationID;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 21:10
 * @Description: 用户地址的管理层
 */
//RestController=controller+responseBody
@RestController
//RequestMapping设置当controller收到users下的所有请求时，都会被UserController所接管
@RequestMapping("addresses")
public class AddressController extends BaseController
{
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address,HttpSession session)
    {
        addressService.addNewAddress(getUserNameFromSession(session),getUidFromSession(session),address);
        return new JsonResult<>(SAVE_OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> selectByUid(HttpSession session)
    {
        List<Address> addresses = addressService.selectAddressByUid(getUidFromSession(session));
        return new JsonResult<>(SAVE_OK,addresses);
    }

    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session)
    {
        addressService.setDefault(aid,getUidFromSession(session),getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> deleteAddress(@PathVariable("aid") Integer aid, HttpSession session)
    {
        addressService.deleteAddress(aid,getUidFromSession(session),getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK);
    }


}