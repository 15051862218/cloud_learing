package com.mth.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: mth
 * @date: 2022/9/6
 **/
@SpringBootApplication
//指定包名加载
@EnableFeignClients(basePackages = {"com.mth.content"})
//通过类名来加载
//@EnableFeignClients(clients = {com.mth.content.openfeign.UserService.class})
//扫苗特定类所在路径下的FeignClients
//@EnableFeignClients(basePackageClasses = {UserService.class})
public class ContentCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class);
    }
}
