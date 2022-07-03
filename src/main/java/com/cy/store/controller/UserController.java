package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.security.x509.AVA;

import javax.lang.model.element.VariableElement;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-19 21:10
 * @Description: 用户的
 */
//RestController=controller+responseBody
@RestController
//RequestMapping设置当controller收到users下的所有请求时，都会被UserController所接管
@RequestMapping("users")
@Api(tags = "用户管理")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    @ApiOperation("注册用户")
    @ApiImplicitParam(name = "user",value = "用户信息",readOnly = true)
    //RequestBody表示此方法的响应结果以json的格式进行数据的响应给到前端
    public JsonResult<Void> reg(User user)
    {
        userService.reg(user);
        System.out.println("注册成功");
        JsonResult<Void> result = new JsonResult<>(SAVE_OK);
        return result;
    }
    

    //这里参数中的httpsession用于保存用户第一次登录后所产生的的数据，该session是全局的，确保登录后的用户数据可以被全局访问到
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session)
    {
        User user = userService.login(username, password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username", user.getUsername());
        System.out.println("登录成功 用户为:" + username + "uid为" + user.getUid());
        JsonResult<User> userJsonResult = new JsonResult<>(LOGIN_OK,user);
        return userJsonResult;
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        String userName = getUserNameFromSession(session);
        userService.ChangePassword(uid,oldPassword,newPassword,userName);
        return new JsonResult<>(SAVE_OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session)
    {
        User user = userService.getUserByUid(getUidFromSession(session));
        return new JsonResult<User>(SAVE_OK,user);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> ChangeInfo(HttpSession session,User user)
    {
        userService.changUserInfo(getUidFromSession(session),getUserNameFromSession(session),user);
        return new JsonResult<>(SAVE_OK);
    }

    //设置上传头像图片的大小的最大值
    public static final Integer AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    //限制上传文件的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static
    {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    //SpringMvc提供了一个接口MultipartFile用于将指定路径的文件(任何类型)封装称为一个数据包，传递给file
    //@RequestParam表示将请求中指定的参数数据注入到请求处理方法中对应同名的参数，如果不一致则可以强行通过该注解进行标记映射
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            throw new FileEmptyException("文件为空");
        }
        if(file.getSize() > AVATAR_MAX_SIZE)
        {
            throw new FileSizeException("文件大小超出限制");
        }
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType))
        {
            throw new FileTypeException("文件类型不支持");
        }

        //指定所有上传的文件的目录
        String parent = session.getServletContext().getRealPath("upload");

        //首先创建一个文件对象指向我们指定的文件路径，进行文件目录是否存在的判断
        File dir = new File(parent);
        if(!dir.exists())
        {
            //如果目录不存在则创建当前的目录
            dir.mkdirs();
        }

        //获取到文件名称，利用UUID工具来生成一个新的字符串作为文件名
        String originalFilename = file.getOriginalFilename();
        //获取到文件名中'.'的位置，同时利用substring来获取该文件的后缀名
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        //通过UUID和之前获取到的文件的后缀名拼接获取到新的文件名
        String fileName = UUID.randomUUID().toString().toUpperCase() + suffix;

        /*
            下面开始上传文件的大致思路
            创建一个空文件，文件名即为我们获取到的新文件名，
            然后将file中的文件数据copy到我们所创建的这个空文件中，即达到用户文件上传至指定目录的操作
         */
        //创建一个文件，dir目录下的文件名为filename的空文件
        File dest = new File(dir,fileName);
        //将参数file中的文件数据写入到我们创建的空文件中
        try
        {
            //将同后缀名的file文件数据写入到指定的另一个dest文件当中
            file.transferTo(dest);
        } catch (FileStateException e)
        {
            throw new FIleUploadIOException("文件状态异常");
        } catch (IOException e)
        {
            throw new FIleUploadIOException("文件读写异常");
        }

        //由于我们将上传的文件保存至工程的目录中，所以使用文件的相对路径即可
        String avatar = "/upload/" + fileName;
        userService.changeAvatar(getUidFromSession(session),avatar,getUserNameFromSession(session));
        return new JsonResult<>(SAVE_OK,avatar);

    }












}