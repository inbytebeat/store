package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 无法找到对应的购物车数据
 */
public class CartNotFoundException extends ServiceException
{
    public CartNotFoundException()
    {
        super();
    }

    public CartNotFoundException(String message)
    {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CartNotFoundException(Throwable cause)
    {
        super(cause);
    }

    protected CartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
