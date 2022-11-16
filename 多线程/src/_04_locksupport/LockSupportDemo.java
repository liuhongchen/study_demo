package _04_locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {





    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            System.out.println("t1 come in");
            LockSupport.park();
//            LockSupport.unpark(t2);
            System.out.println("t1 unPark");
        }, "t1");


        Thread t2 = new Thread(() -> {
            System.out.println("t2 come in");
            LockSupport.unpark(t1);

            LockSupport.park();
            System.out.println("t2 unPark");
        }, "t2");


    }
}
