package com.example.serch.cotroller;


import com.alibaba.fastjson.JSONArray;
import com.example.serch.pojo.Bean;
import com.example.serch.service.Inservice;
import com.example.serch.serviceimpl.Inserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/7 9:59
 */
@RestController
@ResponseBody
public class Conntroller {
    @Autowired
    private Inserviceimpl inserviceimpl;
    @RequestMapping("/in")
    public int in(){
        return inserviceimpl.readJsonFile("北极星电力网.json");
    }
    @RequestMapping("/take")
    public  int take(){

    }
}
