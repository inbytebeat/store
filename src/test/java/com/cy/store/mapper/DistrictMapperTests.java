package com.cy.store.mapper;

import com.cy.store.entity.District;
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
public class DistrictMapperTests
{
    @Autowired
    private DistrictMapper districtMapper;
    @Test
    public void findByParent()
    {
        List<District> byParent = districtMapper.findByParent("110100");
        System.out.println(byParent.toString());
    }

    @Test
    public void findByCode()
    {
        String regStr = districtMapper.findNameByCode("110101");
        System.out.println(regStr);
    }


}