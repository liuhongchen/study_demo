package _2_方法引用;

/**
 * ClassName:Apple
 * Package:_2_方法引用
 * Description:
 *
 * @date: 2022-05-25 16:58
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Apple {

    int weight;
    String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
