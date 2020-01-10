package com.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * ClassName:Dog
 * Package:com.entity
 * Description:
 *
 * @date:2019-12-28 21:06
 * @author:892698613@qq.com
 */
public class Dog implements InitializingBean, DisposableBean {

    public Dog() {
        System.out.println("dog constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy dog");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init dog");
    }
}
