package pv;

import org.junit.Test;

/**
 * ClassName:Main
 * Package:pv
 * Description:
 *
 * @date: 2023-03-29 16:03
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class SyncPV {


    class MyBlockingQueue {
        int mutex = 0;
        public synchronized void put() throws InterruptedException {
            if (mutex == 1) wait();
            System.out.println("put");
            mutex++;
            notifyAll();
        }
        public synchronized void take() throws InterruptedException {
            if (mutex == 0) wait();
            System.out.println("take");
            mutex--;
            notifyAll();
        }
    }


    @Test
    public void test() throws InterruptedException {

        MyBlockingQueue blockingQueue=new MyBlockingQueue();

        new Thread(()->{
            try {
                while (true){
                    blockingQueue.put();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Thread t=new Thread(()->{
            try {
                while (true){
                    blockingQueue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        t.join();
    }
}
