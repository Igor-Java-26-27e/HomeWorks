package homework8;

public class Robot {
    private int run;
    private int jump;
    private String className;

    public Robot (int run, int jump) {
        this.run = run;
        this.jump = jump;
        className = getClass().getSimpleName();
    }

    public int getRun() {
        return run;
    }

    public int getJump() {
        return jump;
    }

    public void run(Treadmill treadmill){
            System.out.print(className);
            treadmill.run(run);
    }
    public void jump(Wall wall) {
        System.out.print(className);
        wall.jump(jump);
    }
}
