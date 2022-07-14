package lesson11.lesson10Update;

import java.util.Scanner;

public class Employee implements Comparable<Employee> {
    private String name;
    private String position;
    private int salary;
    private int age;

    public Employee(String name, String position, int salary, int age) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static Employee scanEmployee(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String position = scanner.next();
        int salary = scanner.nextInt();
        int age = scanner.nextInt();
        return new Employee(name, position,salary,age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
