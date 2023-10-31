package com.shizheng.teachermanagesystem.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shizheng
 */
@Configuration
@ConfigurationProperties(prefix = "spring.rocketmq")
public class RocketMQProducerConfiguration {

    @Value("${spring.rocketmq.name-server}")
    private String nameServer;

    @Value("${spring.rocketmq.producer.group}")
    private String group;

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(nameServer);
        producer.start();
        return producer;
    }
}
