package HomeWork1;

import HomeWork1P.Employee;

/**
* Java Pro. Homework #1
* @author Igor Cijov
* @version 13 Jun 2022
*/
/*Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        Конструктор класса должен заполнять эти поля при создании объекта.
        Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        Создать массив из 5 сотрудников.
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(…);
        …
        persArray[4] = new Person(…);
        С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/


public class ProcessingEmployee {

    public static void main(String[] args) {
        HomeWork1P.Employee[] employees = {
                new HomeWork1P.Employee("Ivanov Ivan", "Engineer", "ivanov@gmail.com", "+4917432354", 2243.53, 41),
                new HomeWork1P.Employee("Timur Scvortov", "Architect", "timur@yahoo.com", "+30120549867", 2598.73, 35),
                new HomeWork1P.Employee("Elena Sidorova", "Contabil", "e.sidorova@mail.ru", "+7932457933", 1985.4, 54),
                new HomeWork1P.Employee("Maxim Sergheev", "Traktorist", "sergheecm@gmail.com", "+14523054324", 1550.87, 43),
                new HomeWork1P.Employee("Violeta Karamanova", "Povar", "v_karamanova@rambler.ru", "+393245875434", 2030.34, 32)
        };
        for (Employee employee : employees){
            if (employee.getAge() > 40){
                System.out.println(employee);
            }
        }
    }
}
