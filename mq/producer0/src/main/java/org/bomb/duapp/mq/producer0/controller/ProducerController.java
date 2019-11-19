package org.bomb.duapp.mq.producer0.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProducerController {
    @Resource
    RocketMQTemplate rocketMQTemplate;

    @Value("${topic0}")
    String topic0 ;

    @GetMapping("rocket/sync/producer")
    public String producer(String name, String remark) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic0, name + remark);
        return sendResult.getMsgId();
    }

}
