package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-20 12:41
 * @Description: 用户未找到异常
 */
public class UserNotFoundException extends ServiceException
{
    public UserNotFoundException()
    {
        super();
    }

    public UserNotFoundException(String message)
    {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause)
    {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}