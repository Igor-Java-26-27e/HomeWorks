package homework8;

public class Wall implements ISport {
    private int distance;

    public Wall(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String run(int run) {
        return null;
    }

    @Override
    public String jump(int jump) {
        if (distance < jump) {
            System.out.println(" uspeshno prignul " + distance);
        } else {
            System.out.println(" ne smog prignuti " + distance);
        }
        return null;
    }
}