package _3_stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * ClassName:Main
 * Package:_3_stream
 * Description:
 *
 * @date: 2022-05-26 16:54
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class StreamTests {

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    @Test
    public void getThreeHighCaloricDishNames() {
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(3)
                .collect(toList())
                .forEach(System.out::println);
    }


    @Test
    public void getDishNameLengths() {
        //方法1:
        menu.stream()
                .map(dish -> dish.getName().length())
                .collect(toList())
                .forEach(System.out::println);
        //方法2:
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList())
                .forEach(System.out::println);

    }

    @Test
    public void getWordListCharTypes() {
        String[] words = {"hello", "world"};
        Arrays.stream(words)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::print);
        //
//        Arrays.stream(words)
//                .map(s -> s.split(""))
//                .map(strings->{
//                    for (String string : strings) {
//                        return string;
//                    }
//                })
    }

    @Test
    public void getListSquare() {
        int[] arr = {1, 2, 3, 4};
        Arrays.stream(arr)
                .map(val -> val * val)
                .forEach(System.out::println);
    }

    @Test
    public void mixTwoArray() {
        List<Integer> arr1 = Arrays.asList(1, 2, 3);
        List<Integer> arr2 = Arrays.asList(4, 5);

        List<int[]> list = arr1.stream()
                .flatMap(i -> arr2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        list.forEach(arr -> {
            System.out.println(arr[0] + "," + arr[1]);
        });
    }

    @Test
    public void produceSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int val=list.stream()
                .reduce(0,(a,b)->a+b);

        System.out.println(val);
    }

    @Test
    public void produceMax() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream()
                .reduce(Integer::max)
                .ifPresent(System.out::println);

    }

}
