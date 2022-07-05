package homework8;

public class Man {
    private int run;
    private int jump;
    private String className;

    public Man(int run, int jump) {
        this.run = run;
        this.jump = jump;
        className = getClass().getSimpleName();
    }

    public void run(Treadmill treadmill){
            System.out.print(className);
            treadmill.run(run);
    }
    public void jump(Wall wall) {
        System.out.print(className);
        wall.jump(jump);
    }

    public void run(){
       System.out.println(className + " run: " + run);
   }
    public void jump() {
        System.out.println(className + " jump: " + jump);
    }
}
