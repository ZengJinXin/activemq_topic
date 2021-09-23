package com.example.boot_mq_topic_persisten_cosummer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.DefaultBrokerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@EnableJms
@Component
public class ActiveMQConfigBean {
    @Value("${spring.activemq.broker-url}")
    private String broker;
    @Value("${spring.activemq.user}")
    private String username;
    @Value("${spring.activemq.password}")
    private String password;

    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(broker);
        activeMQConnectionFactory.setUserName(username);
        activeMQConnectionFactory.setPassword(password);
        return activeMQConnectionFactory;
    }
    @Bean(name = "JmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        defaultJmsListenerContainerFactory.setSubscriptionDurable(true);
        defaultJmsListenerContainerFactory.setClientId("我是持久化订阅一号");
        return defaultJmsListenerContainerFactory;
    }
}
