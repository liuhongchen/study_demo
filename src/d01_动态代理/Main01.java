package d01_动态代理;

public class Main01 {


    public static void main(String[] args) {
        Calculator calculator=new CalculatorImpl();

        Calculator proxy= (Calculator) new CalculatorProxy(calculator).getProxy();

        int add = proxy.add(1, 1);
        System.out.println("add result :"+add);
    }
}
