package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/12 17:01
 */
@RestController
public class controller {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/saveData")
    public String save(){
        return restTemplate.getForEntity("http://test/in",String.class).getBody();
    }
}
