package com.example.provide.WebSocket;

import java.util.Random;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
@WebServlet(name="BitCoinDataCenter",urlPatterns = "/BitCoinDataCenter",loadOnStartup=1)
public class BitCoinDataCenter extends HttpServlet implements Runnable {
    public void init(ServletConfig config){
        startup();
    }
    private void startup(){
        new Thread(this).start();
    }
    @Override
    public void run() {
        //初始价格常量
        int bitPrice = 100000;
        while (true){
            //线程运行间隔时间1+（0-2）秒之间
            int duration = 1000 + new Random().nextInt(2000);
            try {
                //线程休眠时间
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //新价格围绕100000左右50%波动
            float random = 1+(float) (Math.random()-0.5);
            int newPrice = (int) (bitPrice*random);
            //获取当前页访问总人数
            int total = ServerManager.getTotal();
            //新价格=浮动价格*总访问人数
            newPrice = newPrice*total;
            //定义字符串格式
            String messageFormat = "{price:%d,total:%d}";
            //自定义的字符串类型格式化
            String message = String.format(messageFormat, newPrice,total);
            //广播自定义的字符串
            ServerManager.broadCast(message);
        }
    }
}