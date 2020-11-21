package com.example.hotel.dao;

import com.example.hotel.baen.ReturnValue;
import org.springframework.web.multipart.MultipartFile;

public interface TestMapper {
    public ReturnValue uploadFileTest(MultipartFile zipFile,String fileName) ;

}
