package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 15:34
 * @Description: 收货地址的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address extends BaseEntity
{
    //一次分别是'收货地址id',归属的用户id','收货人姓名','省-名称','省-行政代号','市-名称','市-行政代号','区-名称','区-行政代号','邮政编码',
    // '详细地址','手机','固话','标签','是否默认：0-不默认，1-默认',
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private String provinceCode;
    private String cityName ;
    private String cityCode;
    private String areaName ;
    private String areaCode ;
    private String zip ;
    private String address ;
    private String phone ;
    private String tel ;
    private String tag ;
    private Integer isDefault ;


}