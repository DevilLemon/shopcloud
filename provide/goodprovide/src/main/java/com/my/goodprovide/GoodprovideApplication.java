package com.my.goodprovide;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class GoodprovideApplication {
	public static void main(String[] args) {
		int feignPort = 0;
		int defaultFeignPort = 8010;
		Future<Integer> feignfuture = ThreadUtil.execAsync(() ->{
			int feignP = 0;
			System.out.println("请于5秒钟内输入端口号, 推荐  8010  超过5秒将默认使用 " + defaultFeignPort);
			Scanner feignScanner = new Scanner(System.in);
			while(true) {
				String strRibbonPort = feignScanner.nextLine();
				if(!NumberUtil.isInteger(strRibbonPort)) {
					System.err.println("只能是数字");
					continue;
				}
				else {
					feignP = Convert.toInt(strRibbonPort);
					feignScanner.close();
					break;
				}
			}
			return feignP;
		});
		try{
			feignPort = feignfuture.get(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException | ExecutionException | TimeoutException e){
			feignPort = defaultFeignPort;
		}
		if(!NetUtil.isUsableLocalPort(feignPort)) {
			System.err.printf("端口%d被占用了，无法启动%n", feignPort);
			System.exit(1);
		}
		new SpringApplicationBuilder(GoodprovideApplication.class).properties("server.port=" + feignPort).run(args);
	}
}
