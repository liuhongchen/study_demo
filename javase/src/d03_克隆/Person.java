package d03_克隆;

/**
 * ClassName:Person
 * Package:d03_克隆
 * Description:
 *
 * @date:2019-11-26 16:26
 * @author:892698613@qq.com
 */
public class Person implements Cloneable{

    private String name;

    private Car car;


    public Person() {
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person person= (Person) super.clone();
        if (this.car!=null) {
            person.car = this.car.clone();
        }
        return person;
    }
}
