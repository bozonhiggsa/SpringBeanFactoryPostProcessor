package com.springBeanFactoryPostProcessor.profiling;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test for {@link SimplePOJO} class
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SimplePOJOTest {

    @Test
    public void testPrintPhrase() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_context.xml");
        context.getBean(SimpleInterface.class).printOtherPhrase();
    }
}