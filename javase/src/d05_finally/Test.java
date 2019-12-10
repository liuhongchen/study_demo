package d05_finally;

/**
 * ClassName:Test
 * Package:d05_finally
 * Description:
 *
 * @date:2019-11-26 18:30
 * @author:892698613@qq.com
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(test1(2));
        System.out.println(test(0));
        System.out.println(test(1));
    }


    public static int test1(int n){
        try {
            int r=n*n;
            return r;
        }finally {
            if (n==2) return 0;
        }
    }

    public static int test(int n){
        try {
//            if (n==0) throw new Exception("hello");
            n+=4;
            return n;
        }catch (Exception e){
            n+=2;
            return n;
        } finally {
            System.out.println("f");
        }
    }
}
