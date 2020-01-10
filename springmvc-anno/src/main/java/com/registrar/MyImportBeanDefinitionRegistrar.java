package com.registrar;

import com.controller.MyController;
import com.service.MyService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ClassName:MyImportBeanDefinitionRegistrar
 * Package:com.registrar
 * Description:
 *
 * @date:2019-12-28 19:39
 * @author:892698613@qq.com
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的类信息
     * @param registry beanDefinition的注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //这里好像必须要加全限定类名
        boolean hasPerson = registry.containsBeanDefinition("com.entity.Person");
        if (hasPerson){
            RootBeanDefinition beanDefinition=new RootBeanDefinition(MyService.class);
            registry.registerBeanDefinition("myService",beanDefinition);
        }
    }
}
