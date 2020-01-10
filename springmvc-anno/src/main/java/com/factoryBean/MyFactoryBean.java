package com.factoryBean;

import com.dao.MyDao;
import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName:MyFactoryBean
 * Package:com.factoryBean
 * Description:
 *
 * @date:2019-12-28 19:55
 * @author:892698613@qq.com
 */
public class MyFactoryBean implements FactoryBean<MyDao> {

    @Override
    public MyDao getObject() throws Exception {
        return new MyDao();
    }

    @Override
    public Class<?> getObjectType() {
        return MyDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
