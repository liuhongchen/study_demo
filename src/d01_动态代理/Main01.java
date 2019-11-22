package d01_动态代理;

//import d01_动态代理.getProxyInstance方式.CalculatorProxy;

import d01_动态代理.getProxyClass方式.ObjectProxy;

import java.util.Properties;

public class Main01 {

    
    public static void main(String[] args) throws Exception {

        Properties properties=System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");



         //使用newProxyInstance方法获取

        Calculator calculator=new CalculatorImpl();

        Calculator proxy= (Calculator) new ObjectProxy(calculator).getProxy();

        int add = proxy.add(1, 1);
        System.out.println("add result :"+add);


        //使用getProxyClass方法获取



    }
}
