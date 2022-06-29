package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:46
 * @Description: 作为泛指文件上传的异常的基类
 */
public class FIleUploadException extends RuntimeException
{
    public FIleUploadException()
    {
        super();
    }

    public FIleUploadException(String message)
    {
        super(message);
    }

    public FIleUploadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FIleUploadException(Throwable cause)
    {
        super(cause);
    }

    protected FIleUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}