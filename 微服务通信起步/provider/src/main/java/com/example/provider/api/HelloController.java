package com.example.provider.api;


import com.example.provider.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/8/30 16:45
 * @Version 1.0
 */


@RestController
@RequestMapping(value = "/api")
public class HelloController {
    @GetMapping("/searching")
    public String search(){
        Student student = Student.builder().nane("沈永康").id(1).job("web工程师").build();
        System.out.println(student);
        return student.toString();
    }
}