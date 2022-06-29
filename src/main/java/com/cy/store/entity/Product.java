package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-28 17:02
 * @Description: 商品的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product extends BaseEntity implements Serializable
{
    private Integer id;
    //分类的id
    private Integer categoryId;
    private Integer num;
    //商品状态  1：上架   2：下架   3：删除
    private Integer status;
    //显示优先级
    private Integer priority;
    private Long price;
    private String itemType;
    private String title;
    private String sellPoint;
    private String image;

}