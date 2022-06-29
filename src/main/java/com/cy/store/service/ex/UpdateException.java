package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-22 21:34
 * @Description: 用户处理用户更新时所产生的位置的异常
 */
public class UpdateException extends ServiceException
{
    public UpdateException()
    {
        super();
    }

    public UpdateException(String message)
    {
        super(message);
    }

    public UpdateException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UpdateException(Throwable cause)
    {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}