package pv;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:ConditionPV
 * Package:pv
 * Description:
 *
 * @date: 2023-03-29 16:16
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class ConditionPV {

    class MyBlockingQueue {

        int mutex = 0;

        ReentrantLock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();

        public void put() {

            lock.lock();

            try {
                while (mutex == 1) empty.await();
                mutex++;
                System.out.println("put");
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }


        public void take() {

            lock.lock();

            try {
                while (mutex == 0) full.await();
                mutex--;
                System.out.println("take");
                empty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


    @Test
    public void test() throws InterruptedException {

        MyBlockingQueue blockingQueue = new MyBlockingQueue();

        new Thread(() -> {
            try {
                while (true) {
                    blockingQueue.put();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    blockingQueue.put();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        Thread t = new Thread(() -> {
            try {
                while (true) {
                    blockingQueue.take();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.start();
        t.join();
    }
}
