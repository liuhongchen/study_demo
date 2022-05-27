package test;

/**
 * ClassName:Test2
 * Package:test
 * Description:
 *
 * @date: 2021-05-12 17:09
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Test2 {


    public static void main(String[] args) {


        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i%3==0){
                i+=3;
            }else if (i%4==0){
                i+=2;
            }

        }
    }
}
