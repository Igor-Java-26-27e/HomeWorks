package lesson15.serializableEx;

import java.io.Serializable;

public class Cat implements Serializable { // Interface marker se foloseste pentru ca obiectul Cat sa poata fi Serializat
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '}';
    }
}
