package _2_方法引用;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * ClassName:Main
 * Package:_2_方法引用
 * Description:
 *
 * @date: 2022-05-25 16:56
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(10, "Green");
        Apple apple2 = new Apple(20, "Blue");
        Apple apple3 = new Apple(30, "Yellow");
        Apple apple4 = new Apple(40, "Green");


        List<Apple> list = new ArrayList<>();
        list.add(apple3);
        list.add(apple4);
        list.add(apple2);
        list.add(apple1);

        list.stream()
                .filter((apple -> apple.getColor().equals("Green")))
                .sorted(Comparator.comparing(Apple::getWeight)
                        .thenComparing(Apple::toString))
                .collect(toList())
                .forEach(System.out::println);


        list.stream()
                .filter(a -> a.getWeight() > 20)
                .map(Apple::getWeight)
                .collect(toList())
                .forEach(System.out::println);

        Map<String, List<Apple>> collect = list.stream()
                .collect(groupingBy(Apple::getColor));

        collect.keySet()
                .forEach(key -> {
                    System.out.println(key);
                    collect.get(key).forEach(System.out::println);
                });

//        list.sort(Comparator.comparing(Apple::getWeight));
//        System.out.println(list);
    }
}
