package com.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * ClassName:MyTypeFilter
 * Package:com.filter
 * Description:
 *
 * @date:2019-12-28 17:30
 * @author:892698613@qq.com
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 读取到当前正在扫描的扫描类的信息
     * @param metadataReaderFactory 获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前扫描类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类源
        Resource resource = metadataReader.getResource();

        //获取Person 类的元信息Reader
//        metadataReaderFactory.getMetadataReader("Person");

        return classMetadata.getClassName().contains("ers");
    }
}
