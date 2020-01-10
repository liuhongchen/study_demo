package demo01;

import demo01.MyThread;

/**
 * ClassName:demo01.Main
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-12-26 10:18
 * @author:892698613@qq.com
 */
public class Main {



    public static void main(String[] args) {
        MyThread thread1=new MyThread(1);
        MyThread thread2=new MyThread(2);

        thread1.start();
        thread2.start();
    }
}
