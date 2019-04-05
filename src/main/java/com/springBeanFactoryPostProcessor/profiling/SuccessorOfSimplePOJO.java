package com.springBeanFactoryPostProcessor.profiling;

/**
 * New implementation {@link SimpleInterface} interface
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SuccessorOfSimplePOJO extends SimplePOJO {

    @Override
    public void printOtherPhrase() {

        System.out.println("I've got to get going now");
    }

}
