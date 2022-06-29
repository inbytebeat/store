package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:23
 * @Description: 作为业务层异常的基类
 */
public class ServiceException extends RuntimeException
{
    //什么信息都不想抛给外界就使用无参构造方法
    public ServiceException()
    {
        super();
    }

    //向外界抛出一个提示消息
    public ServiceException(String message)
    {
        super(message);
    }

    //抛出异常信息的同时，将异常对象也同时抛出
    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceException(Throwable cause)
    {
        super(cause);
    }

    //抛出所有的信息
    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}