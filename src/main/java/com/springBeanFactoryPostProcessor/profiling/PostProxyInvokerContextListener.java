package com.springBeanFactoryPostProcessor.profiling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

/**
 * Implementation {@link ApplicationListener} interface for support custom's annotation @PostProxy
 * @author Ihor Savchenko
 * @version 1.0
 */
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            if(originalClassName != null){
                try {
                    Class<?> originalClass = Class.forName(originalClassName);
                    Method[] methods = originalClass.getMethods();
                    for (Method method: methods) {
                        if(method.isAnnotationPresent(PostProxy.class)){
                            Object bean = context.getBean(name);
                            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            currentMethod.invoke(bean);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
