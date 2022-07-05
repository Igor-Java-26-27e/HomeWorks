package homework8;
/**
 * Java Pro. homework #8
 * @author Igor Cijov
 * @version 05 Jul 2022
 */

public class ProcessingCatManRobot {
    public static void main(String[] args) {
        Cat cat = new Cat(200, 10);
        Man man = new Man(100, 5);
        Robot robot = new Robot(1000, 1);
        Treadmill treadmill = new Treadmill(150);
        Wall wall = new Wall(9);
        cat.run(treadmill);
        man.run(treadmill);
        robot.run(treadmill);
        System.out.println("-----------------------");
        cat.jump(wall);
        man.jump(wall);
        robot.jump(wall);
    }
}
