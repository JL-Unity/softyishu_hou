package com.example.hotel.server;

import com.example.hotel.baen.ReturnCodeAndMsgEnum;
import com.example.hotel.baen.ReturnValue;
import com.example.hotel.dao.TestMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
@Service
public class TestServiceImp implements TestMapper {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImp.class);

    @Override
    public ReturnValue uploadFileTest(MultipartFile zipFile,String fileName) {
        String targetFilePath = "F:\\yishu\\ershoubook\\src\\main\\resources\\templates\\images";
        String fileSuffix = getFileSuffix(zipFile);
        fileSuffix=".jpg";
        if (fileSuffix != null) {   // 拼接后缀
            fileName += fileSuffix;
        }
        File targetFile = new File(targetFilePath + File.separator + fileName);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
            logger.info("------>>>>>>uploaded a file successfully!<<<<<<------");
        } catch (IOException e) {
            return new ReturnValue<>(-1, null);
        } finally {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                zipFile.getInputStream().close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return new ReturnValue<>(ReturnCodeAndMsgEnum.Success, null);
    }


    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) {    // 无后缀
            return null;
        } else {                    // 存在后缀
            return fileName.substring(suffixIndex, fileName.length());
        }
    }

}


