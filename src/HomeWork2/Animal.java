package HomeWork2;

abstract class Animal implements IAnimal {
    public String name;
    public int runLimit;
    public int swimLimit;
    private static int counter;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        counter++;
    }

    static int getCounter(){
        return counter;
    }

    @Override
    public String toString(){
        return name + ", " + runLimit + ", " + swimLimit;
    }


}
