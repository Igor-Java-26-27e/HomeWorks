package HomeWork3.CatAndPlate;

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int decreaseFood(int appetite) {
        return this.food -= appetite;
    }

    public int addFood(int food){
        return this.food+=food;
    }

    @Override
    public String toString() {
        return food < 0 ? "The amount of food cannot be negative" : "Amount in Plate: " + food;
    }
}