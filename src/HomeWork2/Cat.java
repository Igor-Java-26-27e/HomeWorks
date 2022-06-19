package HomeWork2;

public class Cat extends Animal{
    public Cat (String name, int runLimit, int swimLimit){
        super (name, runLimit, swimLimit);
    }
    @Override
    public int animalRun (){
        return 200;
    }
    @Override
    public int animalSwim (){
        return 0;
    }
}
