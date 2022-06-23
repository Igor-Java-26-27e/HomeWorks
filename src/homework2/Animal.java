package homework2;

abstract class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    private static int countOfAnimals = 0;

    Animal (int runLimit, int swimLimit){
        this. runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        countOfAnimals++;
    }

    public String getClassName(){
        return className;
    }

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    @Override
    public String run(int distance){
        if (distance > runLimit) {
            return className + " could't run " + distance;
        }else{
            return className + " successfully ran " + distance;
        }
    }

    @Override
    public String swim(int distance){
        if (distance > swimLimit){
            return className + " couldn't swim " + distance;
        }else{
            return className + " successfully swim " + distance;
        }
    }

    @Override
    public String toString() {return className + ". runLimit: " + runLimit + ", swimLimit: " + swimLimit;}
}
