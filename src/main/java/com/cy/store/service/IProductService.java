package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Product;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:38
 * @Description: 商品的业务层接口
 */
public interface IProductService
{
    /**
     * 查询前四位的热销商品
     * @return 返回前四个热销产品的清单
     */
    List<Product> selectHotProduct();

    /**
     * 根据商品id查询商品信息
     * @param id 商品id
     * @return 商品详细信息
     */
    Product getById(Integer id);
}
