package lesson24;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Java Pro. Homework #24
 * lesson 24 Reflection Api and Annotations
 *
 * @author Igor Cijov
 * @version 20 September 2022
 */

// Создание объектов

public class MainClass {
    public static void main(String[] args) {
        Class someClass = Cat.class;
        Constructor catConstructor = null;
        try {
            catConstructor = Cat.class.getConstructor(String.class, String.class, int.class);
        Cat cat1 = (Cat)someClass.newInstance();
        Cat cat2 = (Cat)catConstructor.newInstance("Murzik","Black",3);
        } catch (NoSuchMethodException | InvocationTargetException  | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
