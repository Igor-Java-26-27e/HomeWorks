package lesson24;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Java Pro. Homework #24
 * lesson 24 Reflection Api and Annotations
 *
 * @author Igor Cijov
 * @version 20 September 2022
 */

// 11. Работа с методами getMethods() и getDeclaredMethods()

public class MethodClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Method[] methods = Cat.class.getDeclaredMethods();
        for (Method o : methods) {
            System.out.println(o.getReturnType() + " | | | " + o.getName() + " | | | " + Arrays.toString(o.getParameterTypes()));
        }

        try {
            Method mMeow = Cat.class.getDeclaredMethod("meow", int.class);
            mMeow.invoke(cat, 5);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException  | IllegalAccessException e) {
            e.printStackTrace();
        }

        Method m1 = null;
        try {
            m1 = Cat.class.getMethod("jump", null);
            Method m2 = Cat.class.getMethod("meow", int.class);
            System.out.println(m1 + " | " + m2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
