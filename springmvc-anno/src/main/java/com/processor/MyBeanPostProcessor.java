package com.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName:MyBeanPostProcessor
 * Package:com.processor
 * Description:
 *
 * @date:2019-12-28 21:51
 * @author:892698613@qq.com
 */

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(beanName+" init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" destroy");
        return bean;
    }
}
