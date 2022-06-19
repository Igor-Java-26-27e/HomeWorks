package HomeWork3.CatAndPlate;

class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        if ((plate.getFood() > appetite || plate.getFood() == appetite) && satiety != true) {
            plate.decreaseFood(appetite);
            this.satiety=true;

        } else {
            plate.decreaseFood(0);
        }
    }

    @Override
    public String toString() {
        return "Cat: " + name +
                "\n| Appetite: " + appetite +
                "\n| Satiety: " + satiety
                ;
    }
}