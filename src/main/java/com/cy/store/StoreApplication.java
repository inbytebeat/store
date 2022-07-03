package com.cy.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

//配置类
@Configuration
@SpringBootApplication
//利用MapperScan直接扫描指定路径下的所用mapper，就不用在每一个mapper的上面加上@mapper注释,在项目启动时会自动加载所有的接口
@MapperScan("com.cy.store.mapper")
public class StoreApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StoreApplication.class, args);
    }
    //修改springmvc中的对于上传文件的配置
    @Bean
    public MultipartConfigElement getMultipartConfigElement()
    {
        //创建一个配置的工厂类对象
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置需要创建的相关对象的信息 1.上传文件的最大限制 2.发送请求的最大大小
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(15,DataUnit.MEGABYTES));
        //通过工厂类来创建MultipartConfigElement对象
        return factory.createMultipartConfig();
    }
}
