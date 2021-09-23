package com.example.boot_mq_topic_persisten_cosummer.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Topic_Consumer {
    //需要在监听方法指定连接工厂
    @JmsListener(destination = "${myTopicName}",containerFactory = "JmsListenerContainerFactory")
    public void consumer(TextMessage textMessage) throws JMSException{
        System.out.println("订阅着收到消息:    " + textMessage.getText());
    }
}
