package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.baen.Collection;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.baen.User;
import com.example.hotel.dao.BookMapper;
import com.example.hotel.dao.CollectionMapper;
import com.example.hotel.server.Userserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class Collectioncontroller {


    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    Userserver userserver;
    @Autowired
    ResultModel resultModel;



    @RequestMapping("/collectionselectbyuser")
    @ResponseBody
    public ResultModel selectAllbyuser(@RequestParam int userid){
        ArrayList<Collection> collections = (ArrayList<Collection>) collectionMapper.selectAllbyuser(userid);

        if(collections!=null&&collections.size()>0)
        {
            for (int i=0;i<collections.size();i++)
            {
                Collection collection=collections.get(i);
                collection.setBook(bookMapper.selectByPrimaryKey(collection.getBookid()));
            }
        }
            resultModel.setArrayList(collections);
            resultModel.setMsg("请求成功");
            resultModel.setCode(1);

        return resultModel;

    }


    @RequestMapping("/collectiondelebyid")
    @ResponseBody
    public ResultModel deleteByPrimaryKey(@RequestParam int id) {
        int count = collectionMapper.deleteByPrimaryKey(id);

        if (count == 1) {
            resultModel.setData(null);
            resultModel.setMsg("请求成功");
            resultModel.setCode(1);
        } else {
            resultModel.setMsg("请求失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }
    @RequestMapping("/collectiondelebyub")
    @ResponseBody
    public ResultModel collectiondelebyub(@RequestParam int userid,@RequestParam int bookid) {
        Collection collection = collectionMapper.selectonebyub(userid,bookid);
        int count = 0;
        if(collection!=null)
        {
            collectionMapper.deleteByPrimaryKey(collection.getId());

        }

        if (count == 1) {
            resultModel.setData(null);
            resultModel.setMsg("请求成功");
            resultModel.setCode(1);
        } else {
            resultModel.setMsg("请求失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }



    @RequestMapping("/collectionselectonebyub")
    @ResponseBody
    public ResultModel selectonebyub(@RequestParam int userid,@RequestParam int bookid) {
        Collection collection = collectionMapper.selectonebyub(userid,bookid);

        if (collection !=null) {
            resultModel.setData(collection);
            resultModel.setCode(1);
        } else {

            resultModel.setData(collection);
            resultModel.setCode(-1);
        }
        return resultModel;
    }



    @RequestMapping("/collectionadd")
    @ResponseBody
    public ResultModel collectionadd(@RequestParam String collectionstring) {
        Collection collection = JSON.parseObject(collectionstring, Collection.class);
        int count = collectionMapper.insert(collection);

        if (count == 1) {
            resultModel.setMsg("添加成功");
            resultModel.setCode(1);
        } else {
            resultModel.setMsg("添加失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }






}
