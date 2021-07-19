package com.example.serch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 亦梦里 亦书予
 * @version 1.0
 * @date 2021/7/19 11:16
 */
@Configuration
public class Rabbit {
    private static final String Exchange_name ="test" ;
    private static final String Queue_name ="xiaoxi.fanout.queue" ;
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(Exchange_name,false,false);
    }
    @Bean
    public Queue xiaoxiQueue(){
        return new Queue(Queue_name,false);
    }
    @Bean
    public Binding xiaoxiBinding(){
        return BindingBuilder.bind(xiaoxiQueue()).to(fanoutExchange());
    }
}
