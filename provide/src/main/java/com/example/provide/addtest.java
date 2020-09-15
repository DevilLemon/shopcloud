package com.example.provide;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import java.io.File;

public class addtest {
    @Value("${spring.servlet.multipart.location}")
    private String location;
    @Value("${spring.resources.static-locations}")
    private String location2;
    public String path;
    public String addtest(){
        return location;
    }
    public String pathA(){
        path = location;
        return path;
    }
    public String pathB(){
        path = location2;
        return path;
    }
    public String pathway1(){
        String path = getClass().
                getResource("").getPath();
        return path;
    }
    public String pathway2(){
        path = ClassUtils.getDefaultClassLoader().getResource
                ("").getPath();
        return path;
    }
    public String pathway3(){
        String path =  getClass().getClassLoader().
                getResource("").getPath();
        return path;
    }
    public String pathway4(){
        String path = System.getProperty("user.dir");
        return path;
    }
    public String pathway5() throws  Exception{
        File file = new File("static");
        String path = file.getCanonicalPath();
        return path;
    }
}
class start {
    public static void main(String[] args) throws Exception{
        addtest test = new addtest();
        //System.out.println("绝对路径-0：" + test.addtest());
        System.out.println("绝对路径-1：" + test.pathway1());
        System.out.println("绝对路径-2：" + test.pathway2());
        System.out.println("绝对路径-3：" + test.pathway3());
        System.out.println("相对路径-1：" + test.pathway4());
        System.out.println("相对路径-2：" + test.pathway5());
        System.out.println("静态资源路径：" + test.pathA());
        System.out.println("文件特定路径：" + test.pathB());
    }
}