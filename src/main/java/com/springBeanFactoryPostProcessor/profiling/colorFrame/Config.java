package com.springBeanFactoryPostProcessor.profiling.colorFrame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

/**
 * Java Configuration for Color and ColorFrame
 * @author Ihor Savchenko
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.springBeanFactoryPostProcessor.profiling.colorFrame")
public class Config {

    @Bean
    @Scope(value = "prototype")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
}
