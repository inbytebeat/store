package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-22 16:37
 * @Description: 用于定义一个登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor
{
    /**
     *
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器 进行(url+Controller的映射)
     * @return 如果返回值为true表示放行当前的请求，然后响应请求，如果返回值为false则对请求拦截然后重定向到登录页面
     * @throws Exception
     * 作用：检测全局session对象中是否有uid数据，如果有则放行，如果没有则重定向到登录页面
     */
    @Override
    //在调用所有来自网页的请求方法之前进行处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        Object uid = request.getSession().getAttribute("uid");
        if(uid == null)
        {
            //检查请求的session是否包含用户信息，如果没有则重定向到注册页面，然后拦截器返回false终止此次网页请求
            response.sendRedirect("/web/login.html");
            return false;
        }
        //放行此次请求
        return true;
    }

    @Override
    //在ModelAndView对象之后返回被调用的方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    //在整个请求所有关联的资源被执行完毕后所执行的方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}