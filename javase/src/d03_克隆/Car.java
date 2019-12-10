package d03_克隆;

/**
 * ClassName:Car
 * Package:d03_克隆
 * Description:
 *
 * @date:2019-11-26 16:26
 * @author:892698613@qq.com
 */
public class Car implements Cloneable{

    private String brand;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
