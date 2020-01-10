package demo02;

/**
 * ClassName:Consumer
 * Package:demo02
 * Description:
 *
 * @date:2019-12-26 10:25
 * @author:892698613@qq.com
 */
public class Consumer extends Thread{


    public String window;

    public Consumer(int window) {
        this.window = "窗口"+window+":";
    }

    @Override
    public void run() {
        synchronized (this) {
            while (Producer.ticket > 0) {
                System.out.println(window + Producer.ticket--+",剩余"+Producer.ticket);
            }
        }
    }
}
