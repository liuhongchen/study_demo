package com.hansing.distributed._01_tcpBasedRpc.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Provider {


    // 在容器中初始化服务实例
    static Map<String, Object> services = new HashMap<>();
    static {
        services.put(SayHelloService.class.getName(), new SayHelloServiceImpl());
    }


    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            Socket socket = serverSocket.accept();


            //读取服务信息，包括接口、方法名、方法参数列表、传入参数等
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            String interfaceName = input.readUTF();
            String methodName = input.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            Object[] arguments = (Object[]) input.readObject();

            //执行调用
            Class<?> serviceInterfaceClass = Class.forName(interfaceName);
            Object service = services.get(interfaceName);
            Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
            Object result = method.invoke(service, arguments);

            //输出结果
            ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(result);
        }
    }
}
