package org.zero.springcloud.order.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: sell_order
 * @description: 发送消息，即消息发布者
 * @author: 01
 * @create: 2018-08-21 22:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMyQueueTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        for (int i = 0; i < 100; i++) {
            amqpTemplate.convertAndSend("myQueue", "第" + i + "条消息");
        }
    }
}