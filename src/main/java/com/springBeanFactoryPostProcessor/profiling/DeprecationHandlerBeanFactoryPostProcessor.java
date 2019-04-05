package com.springBeanFactoryPostProcessor.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Implementation {@link BeanFactoryPostProcessor} interface for support custom's annotation @DeprecatedClass
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if(beanClassName != null){
                try {
                    Class<?> beanClass = Class.forName(beanClassName);
                    DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                    if(annotation != null){
                        beanDefinition.setBeanClassName(annotation.newImpl().getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
