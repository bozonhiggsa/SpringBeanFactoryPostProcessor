package com.springBeanFactoryPostProcessor.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation {@link BeanPostProcessor} interface for support custom's annotation @Profiling
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<String, Class>();
    private ProfilingController controller = new ProfilingController();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(Profiling.class)){
            map.put(beanName, beanClass);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        Class beanClass = map.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {

                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    if(controller.isEnabled()) {

                        System.out.println("--------------------");
                        System.out.println("Profiling is enabled");
                        Long before = System.nanoTime();
                        Object returnValue = method.invoke(bean, args);
                        Long after = System.nanoTime();
                        System.out.println("Time of performing is: " +(after - before) + " ns");
                        System.out.println("Profiling for that method is completed");
                        System.out.println("--------------------");
                        return returnValue;
                    } else{
                        return method.invoke(bean, args);
                    }
                }
            });
        }

        return bean;
    }
}
