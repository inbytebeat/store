package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-28 21:17
 * @Description: 订单项中的商品数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItem extends BaseEntity implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;

}
