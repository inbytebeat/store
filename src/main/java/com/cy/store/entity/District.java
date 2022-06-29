package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-27 11:16
 * @Description: 省市区的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class District extends BaseEntity
{
    private Integer id;
    private String parent;
    private String code;
    private String name;

    @Override
    public String toString()
    {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}