package com.example.nacosproviderdemo.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/9/2 22:16
 * @Version 1.0
 */

@RestController
public class CloudGoodsApi {
    /**
     * 读取应用的启动端口
     */
    @Value("${server.port}")
    private String applicationServerPort;

    @GetMapping("/goodsServiceTest")
    public String goodsServiceTest() {
        // 返回信息给调用端
        System.out.println("this is port " + applicationServerPort);
        return "this is goods service from port:" + applicationServerPort;
    }
}
