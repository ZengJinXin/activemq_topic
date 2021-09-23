package com.example.boot_mq_topic_cosummer.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class Topic_Consummer {
    @JmsListener(destination = "${myTopicName}")
    public void receive(TextMessage textMessage) throws Exception{
        System.out.println("订阅着收到消息:    " + textMessage.getText());
    }
}
