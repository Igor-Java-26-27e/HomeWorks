package lesson11.lesson10Update;

/**
 * Java Pro. lesson #10 Sorting
 * @author Igor Cijov
 * @version 14 Jul 2022
 */

import java.util.Scanner;

public class Lesson10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        database.init();

        boolean exit = false;
        String name, position;
        int salary, age, index;


        while (!exit) {
            System.out.print("db> ");
            String command = scanner.next();
            switch (command) {
                case "x":
                    exit = true;
                    break;
                case "c":
                    System.out.println("create>");
                    database.create(Employee.scanEmployee());
                    break;
                case "r":
                    System.out.println(database.read());
                    break;
                case "u":
                    System.out.println("update>");
                    String oldname = scanner.next();
                    database.update(oldname, Employee.scanEmployee());

                    break;
                case "d":
                    System.out.println("delete>");
                    name = scanner.next();
                    database.delete(name);
                    break;
                case "f":
                    System.out.println("find>");
                    name = scanner.next();
                    System.out.println(database.find(name));
                    break;
                case "p":
                    //System.out.println(database.getPosition());
                    database.printlist();
                    break;
            }
        }
    }
}
