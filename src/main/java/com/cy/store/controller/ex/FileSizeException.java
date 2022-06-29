package com.cy.store.controller.ex;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-24 16:49
 * @Description: 上传文件大小时的异常
 */
public class FileSizeException extends FIleUploadException
{
    public FileSizeException()
    {
        super();
    }

    public FileSizeException(String message)
    {
        super(message);
    }

    public FileSizeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileSizeException(Throwable cause)
    {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}