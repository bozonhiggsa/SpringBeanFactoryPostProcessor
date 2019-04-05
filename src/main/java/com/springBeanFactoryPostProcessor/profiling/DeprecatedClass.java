package com.springBeanFactoryPostProcessor.profiling;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom's annotation for deprecated classes
 * @author Ihor Savchenko
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

    Class newImpl();
}
