package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:28
 * @Description: 用户名被占用的异常
 */
public class UsernameDuplicatedException extends ServiceException
{
    public UsernameDuplicatedException()
    {
        super();
    }

    public UsernameDuplicatedException(String message)
    {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause)
    {
        super(cause);
    }

    protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}