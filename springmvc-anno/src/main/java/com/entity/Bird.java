package com.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ClassName:Bird
 * Package:com.entity
 * Description:
 *
 * @date:2019-12-28 21:21
 * @author:892698613@qq.com
 */
@Component
@Scope("prototype")
public class Bird {

    public Bird() {
        System.out.println("bird constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("bird init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("bird destroy");
    }
}
