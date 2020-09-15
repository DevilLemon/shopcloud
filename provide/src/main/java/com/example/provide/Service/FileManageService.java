package com.example.provide.Service;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileManageService {
    //获取系统默认存储地址
    @Value("${spring.servlet.multipart.location}")
    private String location;
    public String download(String fileName, HttpServletResponse response){
        File file = new File(location + fileName);
        if (!file.exists()){
            return "文件不存在";
        }
        byte[] bytes = new byte[SIZE];
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            outputStream = response.getOutputStream();
            int length;
            while ((length = bufferedInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();
                }

                if (outputStream != null){
                    outputStream.close();
                }

                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "success";
    }
}
*/