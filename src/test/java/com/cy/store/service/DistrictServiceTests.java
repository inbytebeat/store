package com.cy.store.service;

import com.cy.store.entity.District;
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
public class DistrictServiceTests
{
    @Autowired
    private IDistrictService districtService;

    @Test
    public void findByParent()
    {
        List<District> parent = districtService.getParent("86");
        for (District district : parent) {
            System.out.println(parent);
        }
    }

    @Test
    public void findByCode()
    {
        String regStr = districtService.fineNameByCode("110101");
        System.out.println(regStr);
    }


}