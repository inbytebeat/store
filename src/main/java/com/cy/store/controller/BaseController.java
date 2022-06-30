package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 22:39
 * @Description: 控制层异常的基类 处理所有的控制层异常 这是优化的方法 直接接管所有传递至控制层以及控制层本身的异常
 */
public class BaseController
{
    public static final Integer USERNAME_DUP = 4000;

    public static final Integer ADDRESS_COUNT_ERROR = 4001;
    public static final Integer ADDRESS_NOT_FOUND_ERROR = 4002;
    public static final Integer ADDRESS_DENIED_ERROR = 4003;


    public static final Integer INSERT_ERR = 5000;
    public static final Integer USER_NOTFOUND_ERR = 5001;
    public static final Integer PASSWORD_ERR = 5002;
    public static final Integer UPDATE_ERR = 5002;

    public static final Integer FILE_EMPTY_ERR = 6000;
    public static final Integer FILE_SIZE_ERR = 6001;
    public static final Integer FILE_TYPE_ERR = 6002;
    public static final Integer FILE_STATE_ERR = 6003;
    public static final Integer FILE_UPLOAD_IO_ERR = 6004;

    public static final Integer PRODUCT_NOT_FOUND = 5001;

    public static final Integer CART_NOT_FOUND = 7000;


    public static final Integer SAVE_OK = 200;
    public static final Integer LOGIN_OK = 201;

    /**
     * @Description: 该方法充当的是在项目产生异常之后，拦截异常进行请求处理，其返回值直接给到前端
     * @param e 自动将异常对象赋值给e
     * @return 该方法的返回值就是要传给前端的数据
     */
    @ExceptionHandler({ServiceException.class, FIleUploadException.class})
    public JsonResult<Void> handleException(Throwable e)
    {
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException)
        {
            result.setState(USERNAME_DUP);
            result.setMessage("用户名已被占用的异常");
        }
        else if(e instanceof UserNotFoundException)
        {
            result.setState(USER_NOTFOUND_ERR);
            result.setMessage("用户不存在的异常");
        }
        else if(e instanceof PasswordNotFoundException)
        {
            result.setState(PASSWORD_ERR);
            result.setMessage("用户密码错误");
        }
        else if(e instanceof InsertException)
        {
            result.setState(INSERT_ERR);
            result.setMessage("注册时异常");
        }
        else if(e instanceof UpdateException)
        {
            result.setState(UPDATE_ERR);
            result.setMessage("更新数据时产生位置异常");
        }
        else if(e instanceof FileEmptyException)
        {
            result.setState(FILE_SIZE_ERR);
            result.setMessage("文件存在异常");
        }
        else if(e instanceof FileSizeException)
        {
            result.setState(FILE_SIZE_ERR);
            result.setMessage("文件大小异常");
        }
        else if(e instanceof FileTypeException)
        {
            result.setState(FILE_TYPE_ERR);
            result.setMessage("文件类型异常");
        }
        else if(e instanceof FileStateException)
        {
            result.setState(FILE_STATE_ERR);
            result.setMessage("文件状态异常");
        }
        else if(e instanceof FileSizeException)
        {
            result.setState(FILE_UPLOAD_IO_ERR);
            result.setMessage("文件流异常");
        }
        else if(e instanceof AddressCountLimitException)
        {
            result.setState(ADDRESS_COUNT_ERROR);
            result.setMessage("用户地址数目异常");
        }
        else if(e instanceof AddressNotFoundException)
        {
            result.setState(ADDRESS_NOT_FOUND_ERROR);
            result.setMessage("用户的收货地址不存在");
        }
        else if(e instanceof AddressDeniedException)
        {
            result.setState(ADDRESS_DENIED_ERROR);
            result.setMessage("非法的用户地址");
        }
        else if(e instanceof ProductNotFoundException)
        {
            result.setState(PRODUCT_NOT_FOUND);
            result.setMessage("查询商品异常，商品不存在");
        }
        else if(e instanceof CartNotFoundException)
        {
            result.setState(CART_NOT_FOUND);
            result.setMessage("购物车数据不存在");
        }
        return result;
    }

    /**
     * 获取保存在session中的uid
     * @param session session实现类中 其中保存着初次登录的用户信息
     * @return 当前登录的用户的uid的值
     */
    protected final Integer getUidFromSession(HttpSession session)
    {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取保存在session中的username
     * @param session session的实现类对象
     * @return 当前登录的用户的username的值
     */
    protected final String getUserNameFromSession(HttpSession session)
    {
        return session.getAttribute("username").toString();
    }
}