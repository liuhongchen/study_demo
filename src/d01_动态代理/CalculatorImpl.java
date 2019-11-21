package d01_动态代理;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("正在执行"+a+"+"+b);
        return a+b;
    }
}
