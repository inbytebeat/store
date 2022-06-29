package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-20 12:40
 * @Description: 用户密码错误时的异常
 */
public class PasswordNotFoundException extends ServiceException
{
    public PasswordNotFoundException()
    {
        super();
    }

    public PasswordNotFoundException(String message)
    {
        super(message);
    }

    public PasswordNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PasswordNotFoundException(Throwable cause)
    {
        super(cause);
    }

    protected PasswordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}