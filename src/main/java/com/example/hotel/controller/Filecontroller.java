package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.baen.ReturnValue;
import com.example.hotel.baen.User;
import com.example.hotel.dao.TestMapper;
import com.example.hotel.server.TestServiceImp;
import com.example.hotel.server.Userserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class Filecontroller
{

    private static final Logger logger = LoggerFactory.getLogger(Filecontroller.class);

    @Autowired
    private TestServiceImp testService;

    /**
     * 文件上传测试接口
     * @return
     */
    // @PostMapping("/addKnowledge")
    @RequestMapping("/upload")
    @ResponseBody
    public ReturnValue uploadFileTest(@RequestParam("uploadFile") MultipartFile zipFile,@RequestParam String fileName) {
        return testService.uploadFileTest(zipFile , fileName);
    }

}
