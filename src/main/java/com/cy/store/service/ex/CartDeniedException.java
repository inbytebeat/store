package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 该购物车数据是非法的，不属于对应用户
 */
public class CartDeniedException extends ServiceException
{
    public CartDeniedException()
    {
        super();
    }

    public CartDeniedException(String message)
    {
        super(message);
    }

    public CartDeniedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CartDeniedException(Throwable cause)
    {
        super(cause);
    }

    protected CartDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
