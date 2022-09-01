package com.example.provider.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;


/**
 * @Author 沈永康
 * @Date 2022/8/30 20:14
 * @Version 1.0
 */

@Data
@Builder
public class Student {
    public String nane;
    public int id;
    public String job;

}
