package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:49
 * @Description: 上传文件时，待发送文件的状态异常
 */
public class FileStateException extends FIleUploadException
{
    public FileStateException()
    {
        super();
    }

    public FileStateException(String message)
    {
        super(message);
    }

    public FileStateException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileStateException(Throwable cause)
    {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}