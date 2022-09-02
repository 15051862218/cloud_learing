package com.example.nacosconsumerdemo.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/9/2 22:12
 * @Version 1.0
 */

@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_URL = "http://cloud-goods-service";


    /**
     * 通过Nacos调用下级服务
     * @return String
     */
    @GetMapping("/consumerTest")
    public String consumerTest() {
        return restTemplate.getForObject(SERVICE_URL + "/goodsServiceTest", String.class);
    }

}
