package com.config;

import com.entity.Cat;
import com.entity.Dog;
import com.entity.Person;
import com.factoryBean.MyFactoryBean;
import com.registrar.MyImportBeanDefinitionRegistrar;
import com.selector.MyImportSelector;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

/**
 * ClassName:MyConfig
 * Package:com.config
 * Description:
 *
 * @date:2019-12-28 08:49
 * @author:892698613@qq.com
 */


@Configuration
@ComponentScan(value = "com")
@Import(value = {Person.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }


    @Scope("prototype")
    @Bean(value = "cat",initMethod = "init",destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }

    @Scope("prototype")
    @Bean(value = "dog")
    public Dog dog(){
        return new Dog();
    }
}
