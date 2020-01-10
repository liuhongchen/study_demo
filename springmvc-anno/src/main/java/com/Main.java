package com;

import com.entity.Bird;
import com.entity.Cat;
import com.entity.Dog;
import com.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName:com.Main
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-12-28 08:55
 * @author:892698613@qq.com
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                =new AnnotationConfigApplicationContext(com.config.MyConfig.class);
//        String[] names=applicationContext.getBeanDefinitionNames();
//        for(String name:names){
//            System.out.println(name);
//        }

//        Person person1 = applicationContext.getBean("person", Person.class);
//        Person person2 = applicationContext.getBean("person", Person.class);
//        System.out.println(person1==person2);

//        Cat cat=applicationContext.getBean("cat",Cat.class);

//        Dog dog = applicationContext.getBean("dog", Dog.class);
        Bird bird=applicationContext.getBean("bird",Bird.class);

        applicationContext.close();
    }
}
