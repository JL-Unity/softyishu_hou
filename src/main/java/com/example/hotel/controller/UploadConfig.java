package com.example.hotel.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.*;

@Configuration
public class UploadConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
//        InputStream is=this.getClass().getResourceAsStream("/main/resources/templates/images");
//        BufferedReader br=new BufferedReader(new InputStreamReader(is));
//        String s="";
//        while(true) {
//            try {
//                if (!((s=br.readLine())!=null)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
       // registry.addResourceHandler("/images/**").addResourceLocations(s);
        //String targetFilePath = "./src/main/resources/templates/images/";
        registry.addResourceHandler("/images/**").addResourceLocations( "file:./src//main/resources/templates/images/");
      //registry.addResourceHandler("/images/**").addResourceLocations( "file:F:/yishu/ershoubook/src/main/resources/templates/images/");
      //registry.addResourceHandler("/images/**").addResourceLocations( "$ProjectFileDir$/ershoubook/src/main/resources/templates/images/");
       }
}