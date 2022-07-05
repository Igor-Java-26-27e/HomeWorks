package homework8;

public class Treadmill implements ISport {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String run (int run){
        if (distance<run){
            System.out.println(" uspeshno probejal " + distance);
        }else{
            System.out.println(" ne smog probejati " + distance);

        }
            return null;
        }


    @Override
    public String jump(int distance) {
        return null;
    }
}
