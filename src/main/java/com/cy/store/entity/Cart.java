package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-28 20:17
 * @Description: 购物车的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cart extends BaseEntity implements Serializable
{
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;

}