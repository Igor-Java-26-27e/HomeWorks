package homework3.CatAndPlate;
/**
 * Java Pro. Homework #3
 * @author Igor Cijov
 * @version 19 Jun 2022
 */

import java.util.Scanner;

public class CatAndPlateProcessing {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Tuzik", 15),
                new Cat("Murzik", 30)
        };
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("Put the Food in the Plate:");
        Plate plate = new Plate(keyboard.nextInt());

        while (1 == 1) {
            System.out.println(plate);
            System.out.println("---------------------------");
            for (Cat cat : cats) {
                System.out.println(cat.getName() + ", " + "Satiety: " + (cat.isSatiety() ? "Well-Fed" : "Hungry") + " " + cat.getAppetite());
                cat.eat(plate);
                System.out.println(cat.getName() + " satiety: " + (cat.isSatiety()? "Well-Fed" : "Hungry"));
                System.out.println(plate);
                System.out.println("---------------------------");
            }
            System.out.println("Add the Food in the Plate:");
            plate.addFood(keyboard.nextInt());
            System.out.println();
        }
    }
}
