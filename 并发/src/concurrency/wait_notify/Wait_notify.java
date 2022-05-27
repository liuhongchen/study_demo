package concurrency.wait_notify;

/**
 * ClassName:Wait_notify
 * Package:concurrency
 * Description:
 *
 * @date: 2021-05-04 09:19
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Wait_notify {

    static int num = 0;

    public static void main(String[] args) {


        Thread provider = new Thread(new Runnable() {
            @Override
            public void run() {
                if (num > 0) {
                    synchronized (this) {
                        try {
                            System.out.println("----provider进入等待");
                            this.wait();
                            System.out.println("----provider结束等待");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num++;
                System.out.println("provider生产包子");
                synchronized (this) {
                    this.notifyAll();
                }
            }

        });


        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (num <= 0) {
                    synchronized (this) {
                        try {
                            System.out.println("----consumer1进入等待");
                            this.wait();
                            System.out.println("----consumer1结束等待");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num--;
                System.out.println("consumer1消费包子");
                synchronized (this) {
                    this.notifyAll();
                }
            }
        });

//        Thread consumer2 =new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (num==0){
//                        synchronized (this){
//                            try {
//                                System.out.println("----consumer2进入等待");
//                                this.wait();
//                                System.out.println("----consumer2结束等待");
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    try {
//                        Thread.sleep(3000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    num--;
//                    System.out.println("consumer2消费包子");
//                    synchronized (this){
//                        this.notify();
//                    }
//                }
//            }
//        });

        provider.start();
        consumer1.start();
//        consumer2.start();


    }


}

class Provider implements Runnable {


    @Override
    public void run() {
    }
}
