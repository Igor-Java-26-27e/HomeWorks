package homework4;

import java.util.Arrays;

public class LessonFive {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray();
        ra.add(5);
        ra.add(10);
        ra.add(15);
        ra.add(25);
        System.out.println(ra.size() + ": " + ra);
        System.out.println("max = " + ra.getMax());
        System.out.println("min = " + ra.getMin());
        System.out.println(("Average = " + ra.getAverage()));
        System.out.println(ra.get(1));
        ra.remove(1);
        ra.remove(2);
        System.out.println(ra);
        ra.remove(0);
        System.out.println(ra);
        ra.remove(0);
        System.out.println(ra);
        ra.add(9);
        System.out.println(ra);
    }
}

class RubberArray {
    private int[] array;

    public void add(int value) {
        if (array == null) {
            array = new int[1];
            array[0] = value;
        } else {
            int[] newArray = new int[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = value;
            array = newArray;
        }

    }

    public int get(int idx) {
        return array[idx];
    }

    public int size() {
        return array != null ? array.length : 0;
    }

    public void remove(int idx) {
        if (array != null) {
            if (idx < array.length) {
                int[] newArray = new int[array.length - 1];
                System.arraycopy(array, 0, newArray, 0, idx);
                System.arraycopy(array, idx + 1, newArray, idx, array.length - idx - 1);
                array = newArray;
            }
        }
    }

    public int getMax() {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int getMin() {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public double getAverage() {
        double sum = 0;
        double average;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        return average;
    }

    @Override
    public String toString() {
        return array != null ? Arrays.toString(array) : "[]";
    }
}
