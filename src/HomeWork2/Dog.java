package HomeWork2;

public class Dog extends Animal{
    public Dog (String name, int runLimit, int swimLimit){
        super (name, runLimit, swimLimit);
    }
    @Override
    public int animalRun (){
        return 500;
    }
    @Override
    public int animalSwim (){
        return 10;
    }
}
