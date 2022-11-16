package com.hansing.distributed._01_tcpBasedRpc.provider;

public class SayHelloServiceImpl implements SayHelloService {
    public String sayHello(String helloArg) {
        if (helloArg.equals("hello")) {
            return "hello";
        } else {
            return "bye bye";
        }
    }
}
