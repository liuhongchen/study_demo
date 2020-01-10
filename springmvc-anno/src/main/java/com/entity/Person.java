package com.entity;

import com.condition.WinCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


/**
 * ClassName:Person
 * Package:com.entity
 * Description:
 *
 * @date:2019-12-28 08:49
 * @author:892698613@qq.com
 */
@Repository
@Conditional(value = {WinCondition.class})
public class Person {
}
