package _07_读写锁;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyResource {

    Map<String, String> map = new HashMap<>();
    Lock lock = new ReentrantLock();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String k,String v) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入");
            map.put(k,v);
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void read(String k) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取");
            map.get(k);
            System.out.println(Thread.currentThread().getName()+"读取完成");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {

}
