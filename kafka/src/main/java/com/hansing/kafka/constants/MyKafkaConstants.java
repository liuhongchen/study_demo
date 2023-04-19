package com.hansing.kafka.constants;


public class MyKafkaConstants {

    private static final String SERVER1="192.168.1.202:9092";
    private static final String SERVER2="192.168.1.203:9092";
    private static final String SERVER3="192.168.1.204:9092";

    public static final String BOOTSTRAP_SERVER_CONFIG=SERVER1+","+SERVER2+","+SERVER3;
}
