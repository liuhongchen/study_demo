package com.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName:WinCondition
 * Package:com.condition
 * Description:
 *
 * @date:2019-12-28 18:46
 * @author:892698613@qq.com
 */
public class WinCondition implements Condition {

    /**
     *
     * @param context 判断条件可以使用的上下文(环境)
     * @param metadata 注解的元信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Environment environment = context.getEnvironment();
        String os_name = environment.getProperty("os.name");
        return os_name.equals("Mac OS X");
    }
}
