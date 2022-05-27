package _1_lambda;

/**
 * ClassName:Main
 * Package:_1_lambda
 * Description:
 *
 * @date: 2021-06-23 14:54
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Main {


    public static void main(String[] args) {
        LambdaInterface lambda=str -> System.out.println(str);
        lambda.test("hello");
    }
}
