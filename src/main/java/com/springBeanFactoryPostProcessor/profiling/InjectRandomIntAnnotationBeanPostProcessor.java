package com.springBeanFactoryPostProcessor.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Implementation {@link BeanPostProcessor} interface for support custom's annotation @InjectRandomInt
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field: fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                field.setAccessible(true);
                /*try {
                    field.set(bean, annotation.max() - annotation.min());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }*/
                ReflectionUtils.setField(field, bean, annotation.max() - annotation.min());
            }
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
