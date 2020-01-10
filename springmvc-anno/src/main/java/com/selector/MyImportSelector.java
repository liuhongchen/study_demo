package com.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ClassName:MyImportSelector
 * Package:com.selector
 * Description:
 *
 * @date:2019-12-28 19:22
 * @author:892698613@qq.com
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        String[] classes=new String[]{
                "com.controller.MyController"
        };
        return classes;
    }
}
