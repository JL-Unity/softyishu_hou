package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.baen.Booktype;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.dao.BooktypeMapper;
import com.example.hotel.server.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Booktypecontroller
{

    @Autowired
    BooktypeMapper booktypeMapper;
    @Autowired
    ResultModel resultModel;

    
    @RequestMapping("/getAlltype")
    @ResponseBody
    public ResultModel selectAll()
    {
        List<Booktype> booktypeArrayList= booktypeMapper.selectAll();
        resultModel.setArrayList((ArrayList) booktypeArrayList);
        resultModel.setMsg("成功");
        resultModel.setCode(1);
        return resultModel;
    }



}
