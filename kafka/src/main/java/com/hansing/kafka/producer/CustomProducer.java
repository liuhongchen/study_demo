package com.hansing.kafka.producer;


import com.hansing.kafka.constants.MyKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomProducer {


  public static void main(String[] args) {

    // 配置
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, MyKafkaConstants.BOOTSTRAP_SERVER_CONFIG);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //1 创建生产者对象

    KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

    //2 发送数据
    for (int i = 0; i < 5; i++) {
      kafkaProducer.send(new ProducerRecord<>("first", "hello:"+i));
    }

    //3 关闭资源
      kafkaProducer.close();
  }
}