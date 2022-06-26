package homework5;
/**
 * Java Pro. Homework #5
 * @author Igor Cijov
 * @version 26 Jun 2022
 */

import java.util.Arrays;
import java.util.Iterator;

public class UseRubberArray {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray(5, 10, 15, 20);
        ra.addAll(25,30);
        ra.add(5);
        System.out.println(ra);
        System.out.println(ra.getMax());
        System.out.println(ra.average());
        for (Object i : ra){
        System.out.print(((Integer)i+1) + " ");
        }
    }
}

class RubberArray implements Iterable {
    private int[] array = new int[0];

    RubberArray(int... arrayValue){
        addAll(arrayValue);
    }

    public void add (int value){
        addAll(value);
    }

    public void addAll (int... arrayValue){
        int[]newArray = new int[array.length + arrayValue.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(arrayValue, 0, newArray, array.length, arrayValue.length);
        array=newArray;
    }
    public int get(int idx) {
        return array[idx];
    }

    public void set(int idx, int value){
        array[idx] = value;
    }

    public Integer getMax(){
        if(array.length>0){
            int maxValue = array[0];
            for (int i : array){
                if (i > maxValue){
                    maxValue = i;
                }
            }
            return maxValue;
        }
        return null;
    }

    public Double average() {
        if (array.length>0){
            double total = 0;
            for (int i : array){
                total +=i;
            }
            return total/array.length;
        }
        return null;
    }

    public int size() {
        return array.length;
    }

    public boolean remove (int idx){
        if (idx < array.length){
            int[] newArray = new int[array.length -1];
            System.arraycopy(array, 0, newArray, 0, idx);
            System.arraycopy(array, idx+1, newArray, idx, array.length - idx - 1);
            array = newArray;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator{
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor<array.length;
        }

        @Override
        public Object next() {
            return array[cursor++];
        }
    }
}