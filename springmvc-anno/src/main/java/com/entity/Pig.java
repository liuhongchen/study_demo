package com.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName:Pig
 * Package:com.entity
 * Description:
 *
 * @date:2019-12-28 21:42
 * @author:892698613@qq.com
 */
@Component
public class Pig implements BeanPostProcessor {


    public Pig() {
        System.out.println("pig constructor");
    }


}
