package d01_动态代理.getProxyClass方式;


import java.lang.reflect.*;

public class ObjectProxy {

    private Object target;

    public ObjectProxy(Object target) {
        this.target = target;

    }


    public Object getProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        
        ClassLoader classLoader= ObjectProxy.class.getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        Class<?> proxyClass = Proxy.getProxyClass(classLoader, interfaces);

        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance((InvocationHandler) (proxy1, method, args) -> {
            System.out.println("before");

            Object result = method.invoke(target, args);

            System.out.println("after");
            return result;
        });


        return proxy;
    }
}
