package com.example.serch.cotroller;


import com.example.serch.service.Inservice;
import com.example.serch.serviceimpl.Inserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 9:59
 */
@RestController
public class Conntroller {
    @Autowired
    private Inserviceimpl inserviceimpl;
    @RequestMapping("/in")
    public String in(){

        return inserviceimpl.in();
    }
}
