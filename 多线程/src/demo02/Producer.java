package demo02;

/**
 * ClassName:Producer
 * Package:demo02
 * Description:
 *
 * @date:2019-12-26 10:28
 * @author:892698613@qq.com
 */
public class Producer extends Thread {

    public static int ticket;

    @Override
    public void run() {
        synchronized (this) {
            while (ticket > 0) {
                System.out.println("生产了一张票,剩余:"+(++ticket));
            }
        }
    }
}
