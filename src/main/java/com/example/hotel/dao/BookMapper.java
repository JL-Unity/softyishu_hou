package com.example.hotel.dao;

import com.example.hotel.baen.Book;
import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);


    List<Book> selectbytypeid(Integer typeid);

    List<Book> selectbyuserid(Integer userid);



    List<Book> selectbytypeicemin(Integer typeid);
    List<Book> selebig();

    List<Book> selectbyname(Integer typeid,String bookname);

    List<Book> selectallbyname(String bookname);






}