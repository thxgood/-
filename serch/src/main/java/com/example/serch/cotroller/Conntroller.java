package com.example.serch.cotroller;


import com.example.serch.serviceimpl.Inserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    public int in() {
        return inserviceimpl.readJsonFile("北极星电力网.json");
    }

    @RequestMapping("/take")
    public boolean take() {
        return inserviceimpl.getData();
    }

    @RequestMapping("/elasticsearch")
    public boolean elasticsearch() throws IOException {
        return inserviceimpl.elasticsearch();
    }

    @RequestMapping("/putes")
    public boolean test() throws IOException {
        return inserviceimpl.CreateIndex();
    }

    @RequestMapping("/create")
    public boolean create() throws IOException{
        return inserviceimpl.create();
    }
    @RequestMapping("/search")
    public boolean search() throws IOException{
     return inserviceimpl.search();
    }
}