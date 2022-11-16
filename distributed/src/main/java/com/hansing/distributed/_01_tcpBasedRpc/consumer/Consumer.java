package com.hansing.distributed._01_tcpBasedRpc.consumer;

import com.hansing.distributed._01_tcpBasedRpc.provider.SayHelloService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {

    public static void main(String[] args) throws Exception {


        //要调用的接口名和方法
        String interfaceName = SayHelloService.class.getName();
        Method method = SayHelloService.class.getMethod("sayHello", String.class);

        Object[] arguments = {"hello"};//传入的参数

        // 定义socket
        Socket socket=new Socket("127.0.0.1",1234);

        // 通过socket拿到输出流 往Provider传数据
        ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(interfaceName);
        output.writeUTF(method.getName());
        output.writeObject(method.getParameterTypes());
        output.writeObject(arguments);

        // 通过socket拿到输入流 读取远程调用返回的结果
        ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
        Object result = input.readObject();
        System.out.println("得到结果："+ result);
    }
}
