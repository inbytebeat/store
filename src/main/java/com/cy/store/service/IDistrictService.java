package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-27 11:39
 * @Description: 地址的业务层接口
 */
public interface IDistrictService
{
    /**
     * 调用mapper层,根据父区域查询其下所有的区域信息
     * @param parent 父区域编号
     * @return 该父区域编号下的所有区域信息
     */
    List<District> getParent(String parent);

    String fineNameByCode(String code);
}
