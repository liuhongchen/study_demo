package d04_内部类.匿名内部类;

/**
 * ClassName:AnonymousClass
 * Package:d04_内部类.匿名内部类
 * Description:
 *
 * @date:2019-11-26 17:32
 * @author:892698613@qq.com
 */
public class AnonymousClass {

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }
}
