package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 表示删除地址时产生位置的异常
 */
public class DeleteAddressException extends ServiceException
{
    public DeleteAddressException()
    {
        super();
    }

    public DeleteAddressException(String message)
    {
        super(message);
    }

    public DeleteAddressException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DeleteAddressException(Throwable cause)
    {
        super(cause);
    }

    protected DeleteAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
