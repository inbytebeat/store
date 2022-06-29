package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-28 17:11
 * @Description:
 */
public interface ProductMapper
{
    List<Product> findHotList();

    Product findByIdProduct(Integer id);
}
