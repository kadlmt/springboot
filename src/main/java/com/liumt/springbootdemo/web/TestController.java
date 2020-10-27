package com.liumt.springbootdemo.web;

import com.liumt.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ?liumt
 * @date ?Created in 2020/10/27 10:22
 * @description restTemplate
 * @modified By?
 * @version: 1.1
 */
@RestController
@RequestMapping("/api/v1.0/test")
public class TestController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/{id}")
    public User listUsers(@PathVariable("id") Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:8080/api/v1.0/user/{id}";
        return restTemplate.getForObject(url, User.class, id);
    }
}
