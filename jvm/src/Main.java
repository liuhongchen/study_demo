public class Main {

    public static void main(String[] args) {
        System.out.println(Parent.str);
    }


}
class Parent{
    public static String str="hello parent";

    static{
        System.out.println("Parent static block");
    }
}
class Child extends Parent{
    public static String str="hello child";

    static{
        System.out.println("Child static block");
    }
}
