package HomeWork2;

public interface IAnimal {
    default int animalRun() {
        return 300;
    }

    default int animalSwim(){
        return 30;}
}
