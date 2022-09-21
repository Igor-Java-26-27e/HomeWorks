package lesson24.annotations;

import lesson24.Cat;

import java.lang.reflect.Method;

public class ReflectionApp2 {
    @MarkingAnnotation
    public void markedMethod() {
        System.out.println("Java");
    }

    // К аннотациям можно добавлять параметры.
    @AdvancedAnnotation(value = 20.0f)
    public void advAnnotatedMethod() {
        System.out.println("...");
    }

    public static void main(String[] args) {
        Method[] methods = ReflectionApp2.class.getDeclaredMethods();
        for (Method o : methods) {
            if (o.getAnnotation(MarkingAnnotation.class) != null) {
                System.out.println(o);
            }
        }

        try {
            Method m = ReflectionApp2.class.getMethod("advAnnotatedMethod", null);
            AdvancedAnnotation annotation = m.getAnnotation(AdvancedAnnotation.class);
            System.out.println("value: " + annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
