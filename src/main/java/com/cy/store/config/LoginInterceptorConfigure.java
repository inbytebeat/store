package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-22 17:18
 * @Description: 处理器中拦截器的注册
 */
//Configuration定义该类为配置类
@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {

        //创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //对拦截器进行配置，也就是设置白名单黑名单
        //用一个list集合，保存拦截器的白名单
        List<String> whitePatterns = new ArrayList<>();
        //将样式什么的静态资源放行
        whitePatterns.add("/bootstrap3/**");
        whitePatterns.add("/css/**");
        whitePatterns.add("/images/**");
        whitePatterns.add("/js/**");
        //将登录，注册，显示商品,地址信息页面放行
        whitePatterns.add("/web/register.html");
        whitePatterns.add("/web/login.html");
        whitePatterns.add("/web/index.html");
        whitePatterns.add("/web/product.html");
        whitePatterns.add("/users/reg");
        whitePatterns.add("/users/login");
        whitePatterns.add("/districts/**");
        whitePatterns.add("/products/**");
        //首先注册拦截器
        registry.addInterceptor(interceptor)
                //用于表示放行的内容是
                .excludePathPatterns(whitePatterns)
                .excludePathPatterns("/swagger-resources/**","/swagger-ui/**", "/v3/**", "/error")
        //用于表示需要拦截的url是什么
                .addPathPatterns("/**");
    }
}