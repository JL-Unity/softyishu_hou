package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.baen.User;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.server.Userserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class Usercontroller
{

    @Autowired
    Userserver userserver;
    @Autowired
    ResultModel resultModel;

    @RequestMapping("/userlogin")
    @ResponseBody
    public ResultModel userlogin(@RequestParam String username,@RequestParam String password)
    {
        User userbean= userserver.selectBynamepassword(username,password);
        if(userbean!=null)
        {
            resultModel.setData(userbean);
            resultModel.setMsg("登陆成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("登陆失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }
    @RequestMapping("/abd")
    @ResponseBody
    public String userlogin()
    {
        return "2332432432";
    }
    @RequestMapping("/userdelebyid")
    @ResponseBody
    public ResultModel selectBynamepassword(@RequestParam String username,@RequestParam String password)
    {
        User userbean= userserver.selectBynamepassword(username,password);
        if(userbean!=null)
        {
            resultModel.setData(userbean);
            resultModel.setMsg("登陆成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("登陆失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public ResultModel userlogin(@RequestParam String userjson)
    {
        System.out.println(userjson);
        User userbean = JSON.parseObject(userjson,User.class);
        int count=userserver.insert(userbean);
        if(count==1)
        {
            resultModel.setData(userserver.selectBynamepassword(userbean.getUsername(),userbean.getPassword()));
            resultModel.setMsg("注册成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("注册失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }
}
