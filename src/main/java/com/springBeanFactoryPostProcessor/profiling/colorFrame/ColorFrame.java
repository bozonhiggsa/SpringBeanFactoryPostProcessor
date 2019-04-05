package com.springBeanFactoryPostProcessor.profiling.colorFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * Component ColorFrame
 * @author Ihor Savchenko
 * @version 1.0
 */
@Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame(){
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(500));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
