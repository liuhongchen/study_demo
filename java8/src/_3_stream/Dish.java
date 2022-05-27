package _3_stream;

/**
 * ClassName:Dish
 * Package:_3_stream
 * Description:
 *
 * @date: 2022-05-26 16:54
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;//是不是素菜
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}
}
