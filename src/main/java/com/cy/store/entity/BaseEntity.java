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
 * @Date: 2022-06-19 15:46
 * @Description:  当前类作为所有实体类的基类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BaseEntity implements Serializable
{
    //日志-创建人
    private String createdUser;
    //日志-创建时间
    private Date createdTime;
    //日志-最后修改执行人
    private String modifiedUser;
    //日志-最后修改时间
    private Date modifiedTime;

}