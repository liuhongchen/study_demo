package d01_动态代理.getProxyInstance方式;


import java.lang.reflect.Proxy;

public class ObjectProxy {

    private Object target;

    public ObjectProxy(Object target) {
        this.target = target;

    }


    public Object getProxy(){

        
        ClassLoader classLoader= ObjectProxy.class.getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        Object proxy=Proxy.newProxyInstance(classLoader, interfaces, (proxy1, method, args) -> {

            System.out.println(method.getName()+"开始执行");

            Object result = method.invoke(target, args);

            System.out.println(method.getName()+"结束执行");

            return result;
        });

        return proxy;
    }
}
