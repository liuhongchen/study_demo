package d03_克隆;

/**
 * ClassName:Main03
 * Package:d03_克隆
 * Description:
 *
 * @date:2019-11-26 16:28
 * @author:892698613@qq.com
 */
public class Main03 {


    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1=new Person();
        person1.setName("tom");
        person1.setCar(new Car("bmw"));
        Person person2=  person1.clone();
        System.out.println(person1);
        System.out.println(person1.getName()+person1.getCar().getBrand());
        System.out.println(person2);
        System.out.println(person2.getName()+person2.getCar().getBrand());
    }
}
