package homework2;
/**
 * Java Pro. Homework #2
 * @author Igor Cijov
 * @version 16 Jun 2022
 */

public class ProcessingAnimal {
    public static void main(String[] args) {
        homework2.Cat cat = new Cat(200);
        homework2.Dog dog = new Dog(500, 10);

        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(150));
            System.out.println(animal.run(250));
            System.out.println(animal.run(550));
            System.out.println(animal.swim(5));
            System.out.println(animal.swim(15));
        }
        System.out.println("Animals were created: " + Animal.getCountOfAnimals());
    }
}