package com.example.hotel.dao;

import com.example.hotel.baen.Collection;
import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    Collection selectByPrimaryKey(Integer id);

    List<Collection> selectAll();

    int updateByPrimaryKey(Collection record);

    List<Collection> selectAllbyuser(Integer userid);

    Collection selectonebyub(Integer userid,Integer bookid);



}