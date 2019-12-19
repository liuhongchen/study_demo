/**
 * ClassName:Main2
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-12-18 19:54
 * @author:892698613@qq.com
 */
public class Main2 {

    public static void main(String[] args) {

        System.out.println(Parent2.longValue);
    }


}
class Parent2{
//    public static String str1="hello parent";
    public static final String str1="hello parent";
    public static final byte byteValue=6;

    public static final long longValue=2;

    static{
        System.out.println("Parent static block");
    }
}