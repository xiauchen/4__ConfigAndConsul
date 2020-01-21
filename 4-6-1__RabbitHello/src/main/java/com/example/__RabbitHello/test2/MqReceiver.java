package com.example.__RabbitHello.test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: sell_order
 * @description: 接收消息，即消费者
 * @author: 01
 * @create: 2018-08-21 22:24
 **/
@Slf4j
@Component
public class MqReceiver {

    /**
     * 接收消息并打印
     *
     * @param message message
     */
    @RabbitListener(queues = "myQueue")
    public void process(String message) {
        // @RabbitListener注解用于监听RabbitMQ，queues指定监听哪个队列
        log.info(message);
    }
}