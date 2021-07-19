package com.example.serch.serviceimpl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/19 17:53
 */
@Service
@RabbitListener(queues = "xiaoxi.fanout.queue")
public class Mqserver {
    @RabbitHandler
    public  void revicemq(Message message){
        System.out.println(message);
    }

}
