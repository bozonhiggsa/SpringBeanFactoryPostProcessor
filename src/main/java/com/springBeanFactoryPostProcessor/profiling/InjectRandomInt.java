package com.springBeanFactoryPostProcessor.profiling;

import java.lang.annotation.*;

/**
 * Custom's annotation
 * @author Ihor Savchenko
 * @version 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

    int min();

    int max();
}
