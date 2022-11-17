package _06_threadlocal;

public class ThreadLocalDemo {


    ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->0);


    public static void main(String[] args) {
    }
}
