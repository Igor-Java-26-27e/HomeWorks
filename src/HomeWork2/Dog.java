package HomeWork2;

public class Dog extends Animal{
    public Dog (String name, int runLimit, int swimLimit){
        super (name, runLimit, swimLimit);
    }
    @Override
    public int runLimit (){
        return 500;
    }
    @Override
    public int swimLimit (){
        return 10;
    }
}
