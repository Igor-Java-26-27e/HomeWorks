package homework2;

class Cat extends Animal {

    Cat(int runLimit){
        super(runLimit, -1);
    }

    @Override
    public String swim (int distance) {
        return getClassName() + " can't swim";
    }
}
