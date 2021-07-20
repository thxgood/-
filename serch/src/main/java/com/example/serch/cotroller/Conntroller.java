package com.example.serch.cotroller;


import com.example.serch.serviceimpl.Inserviceimpl;
import com.example.serch.serviceimpl.Rabbitmq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/getmq")
    public void getmq(){
       Rabbitmq rabbitmq =new Rabbitmq();
    }
}
