package d04_内部类.成员内部类与静态内部类;

/**
 * ClassName:Outer
 * Package:d04_内部类
 * Description:
 *
 * @date:2019-11-26 17:03
 * @author:892698613@qq.com
 */
public class Outer {

    private  String outValue="outValue";


    public class Inner{
        private String inValue="inValue";

        public String getOutValue(){
            return outValue;
        }

    }

    public String getInValue(){
        Inner inner=new Inner();
        return inner.inValue;
    }


    //在内部类不需要访问外部类的成员时,可以声明为static
    public static class StaticInner{
        private String inStaticValue="inStaticValue";
    }

    public String getStaticInnerValue(){
        StaticInner staticInner=new StaticInner();
        return staticInner.inStaticValue;
    }
}
