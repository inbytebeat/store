package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:49
 * @Description: 上传文件时，文件不存在的异常
 */
public class FileEmptyException extends FIleUploadException
{
    public FileEmptyException()
    {
        super();
    }

    public FileEmptyException(String message)
    {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause)
    {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}