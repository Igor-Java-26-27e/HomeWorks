package homework18;

import homework16.HomeWork16;

import java.util.Arrays;

public class HomeWork18 {

    private static Object monitor = new Object();

    public static void main(String[] args) {
        HomeWork18 test = new HomeWork18();
        new Thread(() -> test.firstMethod()).start();
        new Thread(() -> test.secondMethod()).start();
    }


    public static void firstMethod() {
        synchronized (monitor) {
            int size = 10_000_000;
            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1.0f;
            }
            long a = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("First method time: " + (System.currentTimeMillis() - a) + " ms.");
        }
    }

    public static void secondMethod() {
        synchronized (monitor) {
            int size = 10_000_000;
            int half = size / 2;
            float[] leftHalf = new float[half];
            float[] rightHalf = new float[half];
            float[] mergedArray = new float[size];

            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1.0f;
            }
            long a = System.currentTimeMillis();
            System.arraycopy(arr, 0, leftHalf, 0, half);
            System.arraycopy(arr, half, rightHalf, 0, half);
            //  System.out.println("Array1: " + Arrays.toString(leftHalf));
            //  System.out.println("Array2: " + Arrays.toString(rightHalf));

            System.arraycopy(leftHalf, 0, mergedArray, 0, leftHalf.length);
            System.arraycopy(rightHalf, 0, mergedArray, leftHalf.length, rightHalf.length);
            // System.out.println("Merged Array: " + Arrays.toString(mergedArray));
            System.out.println("Second method time: " + (System.currentTimeMillis() - a) + " ms.");
        }
    }
}

