package com.example.provide.MongoDBT;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
public class uploadFile {
    //@Autowired
    //private FileManageService fileManageService;
    //获取系统默认存储地址
    @Value("${spring.servlet.multipart.location}")
    private String location;
    @Value("${spring.resources.static-locations}")
    private String location2;
    @GetMapping("/getPath")
    public String pathGet(){
        return "静态资源路径" + location2 +";文件上传路径" + location;
    }
    @PostMapping("/lessUpload") //单个文件上传
    public JSONObject lessUpload(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("后台获取：" + file);
        //判断是否获取选择上传的文件
        if (file.isEmpty()) {
            JSONObject jo = new JSONObject();
            jo.putOnce("success",0);
            jo.putOnce("fileName","");
            return jo;
        }
        //获取上传的文件原始名
        String fileName = file.getOriginalFilename();
        //获取上传的文件大小
        int size = (int) file.getSize();
        //拼合上传文件保存的跟路径
        File dest = new File(location + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        file.transferTo(dest); //保存文件
        JSONObject jo = new JSONObject();
        jo.putOnce("success",1);
        jo.putOnce("fileName",fileName);
        return jo;
    }
    @PostMapping("moreUpload") //多个文件上传
    public String moreUpload(HttpServletRequest request) throws Exception{
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        if (files.isEmpty()) { return "false"; }
        for (MultipartFile file : files) {
            //逐个获取原文件名
            String fileName = file.getOriginalFilename();
            //逐个获取文件大小
            int size = (int) file.getSize();
            System.out.println(fileName + "-->大小：" + size);
            if (file.isEmpty()) {
                return "false";
            } else {
                File dest = new File(location + "/" + fileName);
                if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                    file.transferTo(dest);
            }
        }
        return "true";
    }
    @RequestMapping("/testDownload")
    public String downLoad(HttpServletResponse response) throws Exception {
        //输入要下载的文件名
        String filename = "办公软件名单.txt";
        //输入文件所在文件夹路径
        String filePath = "E:/uploadTest";
        //拼接路径和文件名定位文件位置
        File file = new File(filePath + "/" + filename);
        FileInputStream fis; //文件输入流
        BufferedInputStream bis; //缓冲输入流
        OutputStream os; //输出流
        if (file.exists()) { //判断文件父目录是否存在
            //response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" +
                    java.net.URLEncoder.encode(filename, "UTF-8"));
            byte[] buffer = new byte[1024]; //比特缓冲数组
            os = response.getOutputStream(); //获取响应的输出流
            fis = new FileInputStream(file); //获取指定文件输入流
            bis = new BufferedInputStream(fis); //文件输入流转为缓冲输入流
            int i = bis.read(buffer); //缓冲输入流读取写入缓冲数组
            while (i != -1) {
                os.write(buffer); //输出流写入缓冲数组的内容
                i = bis.read(buffer); //缓冲输入流被拿走内容后为-1
            }
            bis.close();
            fis.close();
        }
        return null;
    }
}
