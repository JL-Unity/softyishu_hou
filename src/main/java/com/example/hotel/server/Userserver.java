package com.example.hotel.server;

import com.example.hotel.baen.User;
import com.example.hotel.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Userserver {
    @Autowired
    UserMapper userMapper;
    

    public int deleteByPrimaryKey(int id)
    {
        return  userMapper.deleteByPrimaryKey(id);
    }
    public int  insert(User user)
    {
        return userMapper.insert(user);
    }
    public ArrayList<User> selectAll()
    {
        return (ArrayList<User>) userMapper.selectAll();
    }
    public int  updateByPrimaryKey(User user)
    {
        return userMapper.updateByPrimaryKey(user);
    }

    public User selectBynamepassword(String username,String password)
    {
        return  userMapper.selectBynamepassword(username,password);
    }

    public User selectByPrimaryKey(int id)
    {
        return  userMapper.selectByPrimaryKey( id);
    }
}
