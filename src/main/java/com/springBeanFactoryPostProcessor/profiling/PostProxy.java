package com.springBeanFactoryPostProcessor.profiling;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom's annotation for methods that execute against a background of ContextRefreshedEvent
 * @author Ihor Savchenko
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {
}
