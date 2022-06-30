package com.cy.store.util;

import java.io.Serializable;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 20:54
 * @Description: 所有的对浏览器的响应结果 都采用JsonResult的形式相应
 */
//注： 一个类使用到泛型时，类的声明要包含泛型
public class JsonResult<E> implements Serializable
{
    /** 状态码 **/
    private Integer state;
    /** 描述信息 **/
    private String message;
    /** 实际响应的数据 由于数据类型不确定 所以这里使用了泛型 **/
    private E data;

    public JsonResult(){}

    public JsonResult(Integer state){
        this.state  = state;
    }

    public JsonResult(Integer state,E data)
    {
        this.data = data;
        this.state = state;
    }

    //如果产生了异常 就将异常传给构造方法
    public JsonResult(Throwable throwable)
    {
        this.message = throwable.getMessage();
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}