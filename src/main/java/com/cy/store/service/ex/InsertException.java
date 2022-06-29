package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 执行数据插入操作时产生的异常
 */
public class InsertException extends ServiceException
{
    public InsertException()
    {
        super();
    }

    public InsertException(String message)
    {
        super(message);
    }

    public InsertException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InsertException(Throwable cause)
    {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
