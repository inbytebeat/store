package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:49
 * @Description: 待发送文件的类型异常
 */
public class FileTypeException extends FIleUploadException
{
    public FileTypeException()
    {
        super();
    }

    public FileTypeException(String message)
    {
        super(message);
    }

    public FileTypeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileTypeException(Throwable cause)
    {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}