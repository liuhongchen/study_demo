package _05_cas;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void lock(){
        Thread thread=Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){}
        System.out.println(thread.getName()+"------come in");
    }

    public void unlock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"------out");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo=new SpinLockDemo();

        Thread t1=new Thread(()->{
            spinLockDemo.lock();
            try { Thread.sleep(1000L); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.unlock();
        },"t1");
        t1.start();

        Thread t2=new Thread(()->{
            spinLockDemo.lock();
            try { Thread.sleep(1000L); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.unlock();
        },"t2");
        t2.start();
    }
}
