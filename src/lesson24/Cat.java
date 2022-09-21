package lesson24;

/**
 * Java Pro. Homework #24
 * lesson 24 Reflection Api and Annotations
 * @author Igor Cijov
 * @version 20 September 2022
 */

public class Cat {
    private String name;
    private String color;
    private int age;

    public Cat (String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat (String name, int age){
        this.name = name;
        this.age = age;
    }

    public Cat (String name){
        this.name=name;
    }

    public void meow (int db){
        System.out.println(name + ": meow - " + db + " db");
    }
}
