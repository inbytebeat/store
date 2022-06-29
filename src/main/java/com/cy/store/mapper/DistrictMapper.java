package com.cy.store.mapper;

import com.cy.store.entity.District;

import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-27 11:24
 * @Description: 地址的持久层接口
 */
public interface DistrictMapper
{
    /**
     * 根据父编号来进行区域信息的查询
     * @param parent 父区域号
     * @return 某个父区域下的所有区域列表
     */
    List<District> findByParent(String parent);

    /**
     * 根据编码查询区域信息 例如省 市
      * @param code 地区编码
     * @return 区域名称
     */
    String findNameByCode(String code);
}
