package lesson24;

/**
 * Java Pro. Homework #24
 * lesson 24 Reflection Api and Annotations
 *
 * @author Igor Cijov
 * @version 20 September 2022
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionApp {
    public static void main(String[] args) {
        // 1. У любого Java объекта можно вызвать метод getClass(), который вернет объект типа Class.
        Class stringClass1 = "Java".getClass();

        // 2. Запросить объект типа Class напрямую у класса.
        Class integerClass = Integer.class;
        Class stringClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;
        Class charArrayClass = char[].class;

        // 3. Вызвать статический метод Class.forName(), и передать ему полное имя класса в качестве аргумента.
        try {
            Class StringClass = Class.forName("java.lang.String");
            //    Class jdbcClass = Class.forName("org.sqlite.jdbc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 4. получения имени класса
        System.out.println("4. получения имени класса");
        Class s = String.class;
        System.out.println("Полное имя класса (пакет + имя класса): " + s.getName());
        System.out.println("Простое имя класса (без указания пакета): " + s.getSimpleName());

        System.out.println();

        // 5. Модификаторы класса
        System.out.println("5. Модификаторы класса");
        Class strClass = String.class;
        int modifiers = strClass.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(strClass.getSimpleName() + " -public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(strClass.getSimpleName() + " -abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(strClass.getSimpleName() + " -final");
        }

        System.out.println();

        // 6. Метод getSuperclass()
        System.out.println("6. Метод getSuperclass()");
        System.out.println("For String Class, Super Class is: " + strClass.getSuperclass());
        System.out.println("For Object Class, Super Class is: " + strClass.getSuperclass().getSuperclass());

        System.out.println();

        // 7. Поля класса. Метод getFields()
        System.out.println("7. Поля класса. Метод getFields()");
        Class catClass = Cat.class;
        Field[] publicFields = catClass.getFields();
        for (Field o : publicFields) {
            System.out.println("Тип_поля Имя_поля : " + o.getType().getName() + " " + o.getName());
        }
        // Чтобы получить все поля класса (public, private и protected), применяют метод getDeclaredFields().
        // Зная имя поля, можно получить ссылку на него через метод getField() или getDeclaredField().
        Field f = null;
        try {
            f = catClass.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("(f) is the Field Link: " + f);
        System.out.println();

        // 8. Получить значение поля можно с помощью метода get(), который принимает входным параметром
        // ссылку на объект класса. Для «чтения» примитивных типов применяют методы getInt(), getFloat(),
        // getByte() и другие. Метод set() предназначен для изменения значения поля.
        System.out.println("8. Получить значение поля");
        try {
            Cat cat = new Cat("Pushok");
            Field fieldName = cat.getClass().getField("name");
            fieldName.set(cat, "Murzik");
            Field fieldAge = cat.getClass().getField("age");
            System.out.println(fieldAge.get(cat));
            System.out.println("name is: " + fieldName.get(cat));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 9. Получение доступа к private полям
        System.out.println("9. Получение доступа к private полям");
        try{
        ClassWithPrivateField obj = new ClassWithPrivateField(10);
        obj.info();
        Field privateField = ClassWithPrivateField.class.getDeclaredField("field");
        privateField.setAccessible(true);
        System.out.println("get: " + privateField.get(obj));
        privateField.set(obj, 1000);
        obj.info();
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println();

        //10. Конструкторы класса -getConstructors() и getDeclaredConstructors()-
        System.out.println("10. Конструкторы класса -getConstructors() и getDeclaredConstructors()-");
        Constructor[] constructors = Cat.class.getConstructors();
        for (Constructor o : constructors){
            System.out.println(o);
        }
        System.out.println("---");
        try {
            System.out.println(Cat.class.getConstructor(new Class[] {String.class, int.class}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
