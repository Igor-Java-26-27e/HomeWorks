package lesson12;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Lesson12 {
    public static void main(String[] args) {
        LambdaRun lambdaRun = () -> System.out.println("Hello Lambda!");
        lambdaRun.run();
        lambdaRun = () ->
        {
            for (int i = 0; i < 5; i++) {
                System.out.print(i);

            }
        };
        lambdaRun.run();
        System.out.println();
        ReturnValue value = (a, b) -> a + b;
        System.out.println(value.exec(2,3));
        value = (a,b) -> a*b;
        System.out.println(value.exec(3,3));

        BinaryOperator<Integer> add = (a, b) -> a+b;
        System.out.println(add.apply(2,2));

        UnaryOperator<Integer> twise = (a) -> dd(a);
        System.out.println(twise.apply(5));
    }
    static int dd (int a){
        return a*2;
    }
}
