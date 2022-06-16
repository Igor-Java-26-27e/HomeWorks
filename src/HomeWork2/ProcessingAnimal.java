package HomeWork2;
/**
 * Java Pro. Homework #1
 * @author Igor Cijov
 * @version 16 Jun 2022
 */

public class ProcessingAnimal {
    public static void main(String[] args) {
        IAnimal[]animals = {new Cat("Barsik", 20, 2), new Dog("Tuzik", 400, 4)};
        for (IAnimal animal : animals){
            System.out.println(animal +", "+animal.runLimit()+", "+animal.swimLimit());
        }
        System.out.println(Animal.getCounter());
    }
}
