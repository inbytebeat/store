package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 访问到了非法的地址
 */
public class AddressDeniedException extends ServiceException
{
    public AddressDeniedException()
    {
        super();
    }

    public AddressDeniedException(String message)
    {
        super(message);
    }

    public AddressDeniedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AddressDeniedException(Throwable cause)
    {
        super(cause);
    }

    protected AddressDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
