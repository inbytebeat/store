package com.cy.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 15:57
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Component springboot 约定大于配置 如果字段名称相同可以帮我我们完成自动化配置所以可以不用@Component
public class User extends BaseEntity implements Serializable
{
    private Integer uid;
    private String username;
    private String password;
    //盐值
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    //头像
    private String avatar;
    //是否被删除
    private Integer isDelete;

}