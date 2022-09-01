package com.example.consumer.api;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.SocketImpl;

/**
 * @Author 沈永康
 * @Date 2022/8/30 16:49
 * @Version 1.0
 */

@RestController
public class HelloController {
    private final String SERVICE_URL1 = "http://33091f9t08.zicp.fun:42380/api";
    private final String SERVICE_URL2= "http://2imtpy.natappfree.cc/test1";
    private final String SERVICE_URL3= "http://d4pcqk.natappfree.cc/api";
 @Resource
 private RestTemplate restTemplate;

 private WebClient webClient1 = WebClient.builder().baseUrl(SERVICE_URL1).build();
    private WebClient webClient2 = WebClient.builder().baseUrl(SERVICE_URL2).build();
    private WebClient webClient3 = WebClient.builder().baseUrl(SERVICE_URL3).build();
@GetMapping("/httpClient")
    public String sayHelloToo() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(SERVICE_URL1+"/me");
        CloseableHttpResponse response = null;
        try {
            response= httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                String s = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(s);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }

        return "success";
    }
    @GetMapping("/restTemplateTest")
    public  String restTemplateTest() {
        System.out.println(restTemplate.getForObject(SERVICE_URL1+"/me",String.class));
        return restTemplate.getForObject(SERVICE_URL1 + "/me", String.class);
    }
    @GetMapping("/webClientTest")
    public  String webClientTest(){
        Mono<String> stringMono1 = webClient1.get().uri("/me").retrieve().bodyToMono(String.class);
        stringMono1.subscribe(System.out::println);
        Mono<String> stringMono2 = webClient2.get().retrieve().bodyToMono(String.class);
        stringMono2.subscribe(System.out::println);
        Mono<String> stringMono3 = webClient3.get().uri("/getbook?bookName=aaa&number=123").retrieve().bodyToMono(String.class);
        stringMono3.subscribe(System.out::println);
        return "请求成功";

    }
}
