package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-29 20:17
 * @Description: 订单的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
}
