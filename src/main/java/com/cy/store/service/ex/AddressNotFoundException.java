package com.cy.store.service.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 18:37
 * @Description: 表示修改地址时，该条地址数据不存在的异常
 */
public class AddressNotFoundException extends ServiceException
{
    public AddressNotFoundException()
    {
        super();
    }

    public AddressNotFoundException(String message)
    {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause)
    {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
