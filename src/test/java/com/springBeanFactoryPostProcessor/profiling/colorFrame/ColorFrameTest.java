package com.springBeanFactoryPostProcessor.profiling.colorFrame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Garik on 05.03.2017.
 */
public class ColorFrameTest {

    @Test
    public void testShowOnRandomPlace() throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while(true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(150);
        }
    }

}