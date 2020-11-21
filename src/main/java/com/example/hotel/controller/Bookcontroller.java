package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.baen.Book;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.dao.BookMapper;
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
public class Bookcontroller
{
    @Autowired
    TestServiceImp testService;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ResultModel resultModel;

    @RequestMapping("/bookselectbyid")
    @ResponseBody
    public ResultModel bookselectbyid(@RequestParam int id)
    {
        Book book= bookMapper.selectByPrimaryKey(id);
        if(book!=null)
        {
            resultModel.setData(book);
            resultModel.setMsg("请求成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("请求失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }



     @RequestMapping("/bookselectbytypeid")
    @ResponseBody
    public ResultModel bookselectbytypeid(@RequestParam int  typeid)
    {
        List<Book> books= bookMapper.selectbytypeid(typeid);
        resultModel.setArrayList((ArrayList) books);
        resultModel.setMsg("请求成功");
        resultModel.setCode(1);
        return resultModel;
    }

    @RequestMapping("/bookselectbyuserid")
    @ResponseBody
    public ResultModel bookselectbyuserid(@RequestParam int  userid)
    {
        List<Book> books= bookMapper.selectbyuserid(userid);
        resultModel.setArrayList((ArrayList) books);
        resultModel.setMsg("请求成功");
        resultModel.setCode(1);
        return resultModel;
    }

    @RequestMapping("/bookselectbyname")
    @ResponseBody
    public ResultModel bookselectbyname(@RequestParam int  typeid,@RequestParam String  bookname)
    {
        List<Book> books= bookMapper.selectbyname(typeid,bookname);
        resultModel.setArrayList((ArrayList) books);
        resultModel.setMsg("请求成功");
        resultModel.setCode(1);
        return resultModel;
    }

    @RequestMapping("/bookallselectbyname")
    @ResponseBody
    public ResultModel bookallselectbyname(@RequestParam String  bookname)
    {
        List<Book> books= bookMapper.selectallbyname(bookname);
        resultModel.setArrayList((ArrayList) books);
        resultModel.setMsg("请求成功");
        resultModel.setCode(1);
        return resultModel;
    }







    @RequestMapping("/bookdelebyid")
    @ResponseBody
    public ResultModel bookdelebyid(@RequestParam int  id)
    {

        int  count= bookMapper.deleteByPrimaryKey(id);

        if(count==1)
        {
            resultModel.setData(null);
            resultModel.setMsg("删除成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("删除失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }


    @RequestMapping("/bookdadd")
    @ResponseBody
    public ResultModel roomdadd(@RequestParam("uploadFile") MultipartFile zipFile, @RequestParam String  bookstring)
    {
        Book book = JSON.parseObject(bookstring,Book.class);
        int  count= bookMapper.insert(book);

        if(count==1)
        {
            book = bookMapper.selebig().get(0);
            testService.uploadFileTest(zipFile , "book"+book.getId()+"");
            resultModel.setData(null);
            resultModel.setMsg("添加成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("添加失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }
    @RequestMapping("/bookdupdatafile")
    @ResponseBody
    public ResultModel bookdupdatafile(@RequestParam("uploadFile") MultipartFile zipFile,@RequestParam String  bookstring)
    {
        Book book = JSON.parseObject(bookstring,Book.class);
        int  count= bookMapper.updateByPrimaryKey(book);

        if(count==1)
        {
            testService.uploadFileTest(zipFile , "book"+book.getId()+"");
            resultModel.setData(null);
            resultModel.setMsg("修改成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("修改失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }
    @RequestMapping("/bookdupdata")
    @ResponseBody
    public ResultModel roomdupdata(@RequestParam String  bookstring)
    {
        Book book = JSON.parseObject(bookstring,Book.class);
        int  count= bookMapper.updateByPrimaryKey(book);

        if(count==1)
        {
            resultModel.setData(null);
            resultModel.setMsg("修改成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("修改失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }



    public ArrayList<Book>  selectbytavernpricemin( int  tavernid)
    {
        ArrayList<Book>  room= (ArrayList<Book>) bookMapper.selectbytypeicemin(tavernid);
        return room;
    }

}
