package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Product;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:39
 * @Description: 实现地址处理的Service实现类
 */
@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductMapper productMapper;

    //防止传递的信息量过大，将展示商品页面时所不需要用到的数据置为空
    @Override
    public List<Product> selectHotProduct()
    {
        List<Product> hotList = productMapper.findHotList();
        for (Product product : hotList) {
            product.setPriority(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return hotList;
    }

    public Product getById(Integer id)
    {
        Product product = productMapper.findByIdProduct(id);
        if(product == null)
        {
            throw new ProductNotFoundException("商品不存在");
        }
        product.setPriority(null);
        product.setCreatedTime(null);
        product.setCreatedUser(null);
        product.setModifiedTime(null);
        product.setModifiedUser(null);
        return product;
    }
}