package d04_内部类.局部内部类;

/**
 * ClassName:Outer
 * Package:d04_内部类.局部内部类
 * Description:
 *
 * @date:2019-11-26 17:26
 * @author:892698613@qq.com
 */
public class Outer {

    public String test(){
        class Inner{
            private String innerValue="innerValue";
        }
        Inner inner=new Inner();
        return inner.innerValue;
    }

}
