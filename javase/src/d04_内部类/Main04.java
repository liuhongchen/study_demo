package d04_内部类;

import d04_内部类.成员内部类与静态内部类.Outer;

/**
 * ClassName:Main04
 * Package:d04_内部类
 * Description:
 *
 * @date:2019-11-26 17:06
 * @author:892698613@qq.com
 */
public class Main04 {


    public static void main(String[] args) {
        //测试成员内部类
        Outer outer=new Outer();
        System.out.println(outer.getInValue());

        Outer.Inner inner1=new Outer().new Inner();
        System.out.println(inner1.getOutValue());
        Outer.Inner innner2=outer.new Inner();
        System.out.println(innner2.getOutValue());


        //局部内部类只在其所在方法内可见,只能在其中new
    }
}
