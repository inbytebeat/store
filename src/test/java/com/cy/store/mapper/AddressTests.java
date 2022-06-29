package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
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
public class AddressTests
{
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert()
    {
        Address address = new Address();
        address.setUid(23);
        address.setPhone("13779493958");
        address.setName("本人");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid()
    {
        Integer integer = addressMapper.countByUid(23);
        System.out.println(integer);
    }

    @Test
    public void selectByUid()
    {
        List<Address> byUid = addressMapper.findByUid(31);
        for (Address address : byUid) {
            System.out.println(address);
        }
    }

    @Test
    public void selectByAid()
    {
        Address address = addressMapper.selectByAid(11);
        System.out.println(address);
    }

    @Test
    public void setDefault()
    {
        Integer integer = addressMapper.setDefault(15, "帅哥", new Date());
        System.out.println(integer);
    }

    @Test
    public void setNoDefault()
    {
        Integer integer = addressMapper.setNoDefault(31);
        System.out.println(integer);
    }

    @Test
    public void selectByModifiedTime()
    {
        Address address = addressMapper.orderByCreateTime(31);
        System.out.println(address);
    }


}