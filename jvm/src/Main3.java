import hello.String;

import java.util.UUID;

/**
 * ClassName:Main2
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-12-18 19:54
 * @author:892698613@qq.com
 */
public class Main3 {

    public static void main(String[] args) {

        System.out.println(Parent3.str1);
    }


}

class Parent3{
    public static final String str1= UUID.randomUUID().toString();

    static{
        System.out.println("Parent static block");
    }
}