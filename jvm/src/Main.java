public class Main {

    public static void main(String[] args) {
        System.out.println(Parent.str1);
//        System.out.println(Child.str2);
    }


}
class Parent{
    public static String str1="hello parent";

    static{
        System.out.println("Parent static block");
    }
}
class Child extends Parent{
    public static String str2="hello child";

    static{
        System.out.println("Child static block");
    }
}
