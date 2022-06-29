package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class AddressServiceTests
{
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress()
    {
        Address address = new Address();
        address.setPhone("13779111111");
        address.setName("男朋友");
        addressService.addNewAddress("管理员", 23, address);
    }

    @Test
    public void selectByUid()
    {
        List<Address> byUid = addressService.selectAddressByUid(31);
        for (Address address : byUid) {
            System.out.println(address);
        }
    }

    @Test
    public void setDefault()
    {
        addressService.setDefault(19,31,"阿伟");
    }

    @Test
    public void deleteByAid()
    {
        addressService.deleteAddress(11,31,"小帅哥");
    }
}