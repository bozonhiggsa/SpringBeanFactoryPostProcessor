package com.springBeanFactoryPostProcessor.profiling;

import javax.annotation.PostConstruct;

/**
 * Implementation of {@link SimpleInterface} interface
 * @author Ihor Savchenko
 * @version 1.0
 */
@Profiling
@DeprecatedClass(newImpl = SuccessorOfSimplePOJO.class)
public class SimplePOJO implements SimpleInterface {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public SimplePOJO() {
        System.out.println("Bean of SimplePOJO is created. Field repeat=" + repeat);
    }

    // Аннотация вместо атрибута init-method в теге бина в .xml
    @PostConstruct
    public void init(){
        System.out.println("init() from SimplePOJO is launched. Field repeat=" + repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostProxy
    public void printPhrase() {

        System.out.println("Method with @PostProxy from SimplePOJO is launched. We have message for 'repeat' times:");
        for (int i = 0; i < repeat; i++) {
            System.out.println("Message: " + message);
        }
    }

    public void printOtherPhrase() {

        System.out.println("I've got news for you");
    }
}
