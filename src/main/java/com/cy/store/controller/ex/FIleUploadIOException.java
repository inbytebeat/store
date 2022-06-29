package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:46
 * @Description: 上传文件时的流异常
 */
public class FIleUploadIOException extends RuntimeException
{
    public FIleUploadIOException()
    {
        super();
    }

    public FIleUploadIOException(String message)
    {
        super(message);
    }

    public FIleUploadIOException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FIleUploadIOException(Throwable cause)
    {
        super(cause);
    }

    protected FIleUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}