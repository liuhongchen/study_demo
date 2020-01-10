package demo01;

/**
 * ClassName:MyThread
 * Package:demo01
 * Description:
 *
 * @date:2019-12-26 10:16
 * @author:892698613@qq.com
 */
public class MyThread extends Thread{
    public static int ticket=100;

    public String window;

    public MyThread(int window) {
        this.window = "窗口"+window+":";
    }

    @Override
    public void run() {
        synchronized (this) {
            while (ticket > 0) {
                System.out.println(window + ticket--);
            }
        }
    }
}
