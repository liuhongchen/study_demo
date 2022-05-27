package _3_stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
        int val = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(val);
    }

    @Test
    public void produceMax() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream()
                .reduce(Integer::max)
                .ifPresent(System.out::println);

    }

    @Test
    public void getSumCalories() {
        menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        Integer res = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(res);

    }

    @Test
    public void replaceJoinWithReduce() {
        String ss = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));
        System.out.println(ss);

        String ss2 = menu.stream()
                .map(Dish::getName)
                .reduce("", ((s1, s2) -> s1 + "," + s2))
                .substring(1);
        System.out.println(ss2);

        String ss3 = menu.stream()
                .collect(reducing("", Dish::getName, ((s1, s2) -> s1 + "," + s2)))
                .substring(1);
        System.out.println(ss3);
    }

    @Test
    public void groupingByType() {
        Map<Dish.Type, List<Dish>> typeListMap = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        typeListMap.keySet().forEach(type -> {
            System.out.println(type);
            List<Dish> dishes = typeListMap.get(type);
            dishes.forEach(System.out::println);
        });
    }

    @Test
    public void groupingByIsVegetarian() {
        Map<Boolean, List<Dish>> booleanListMap = menu.stream()
                .collect(Collectors.groupingBy(Dish::isVegetarian));
        booleanListMap.keySet().forEach(bool -> {
            System.out.println(bool);
            List<Dish> dishes = booleanListMap.get(bool);
            dishes.forEach(System.out::println);
        });
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

    @Test
    public void groupingByCalories() {
        Map<CaloricLevel, List<Dish>> caloricLevelListMap = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
        caloricLevelListMap.keySet().forEach(key -> {
            List<Dish> dishes = caloricLevelListMap.get(key);
            System.out.println(key);
            dishes.forEach(System.out::println);
        });
    }

    @Test
    public void groupingByTypeAndCalories() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> map = menu.stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }))
                );
    }

    @Test
    public void countEachTypeCounts() {
        Map<Dish.Type, Long> map = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
    }

    @Test
    public void getMaxOfEachType() {
        Map<Dish.Type, Optional<Dish>> map = menu.stream()
                .collect(groupingBy(Dish::getType,
                                maxBy(Comparator.comparing(Dish::getCalories))));
    }

}
