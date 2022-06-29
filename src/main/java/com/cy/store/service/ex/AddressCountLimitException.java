package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 表示收货地址超出上限的异常 上限为20
 */
public class AddressCountLimitException extends ServiceException
{
    public AddressCountLimitException()
    {
        super();
    }

    public AddressCountLimitException(String message)
    {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause)
    {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
