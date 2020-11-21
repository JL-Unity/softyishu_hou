package com.example.hotel.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class UploadConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
      //  registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\JavaProject\\springboot\\src\\main\\resources\\static\\upload\\");
      //  registry.addResourceHandler("/images/**").addResourceLocations("file:\\Users\\guoweili\\IdeaProjects\\hotel\\src\\main\\resources\\templates\\images\\");
              // registry.addResourceHandler("/images/**").addResourceLocations( "classpath:/images/");
        registry.addResourceHandler("/images/**").addResourceLocations( "file:F:/yishu/ershoubook/src/main/resources/templates/images/");
       }
}