package lesson9;
/**
 * Java Pro. lesson #9
 * @author Igor Cijov
 * @version 10 Jul 2022
 */

import java.util.Arrays;
import java.util.Iterator;

public class UseRubberArray {
    public static void main(String[] args) {
        RubberArray<Integer> ra = new RubberArray<>(5, 10, 15, 20);
        ra.addAll(25,30);
        ra.add(5);
        System.out.println(ra);
        Iterator<Integer> iterator =ra.iterator();
       while (iterator.hasNext()){
           System.out.print(iterator.next() + " ");
       }
        System.out.println();
       RubberArray<String> raStr = new RubberArray<>("A", "B", "C");
        System.out.println(raStr);
    }
}

class RubberArray<E> implements Iterable<E> {
    private Object[] array = new Object[0];

    RubberArray(E... arrayValue){
        addAll(arrayValue);
    }

    public void add (E value){
        addAll(value);
    }

    public void addAll (E... arrayValue){
        Object[]newArray = new Object[array.length + arrayValue.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(arrayValue, 0, newArray, array.length, arrayValue.length);
        array=newArray;
    }
    public E get(int idx) {
        return (E) array[idx];
    }

    public void set(int idx, E value){
        array[idx] = value;
    }

    public int size() {
        return array.length;
    }

    public boolean remove (int idx){
        if (idx < array.length){
            Object[] newArray = new Object[array.length -1];
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
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor<array.length;
        }

        @Override
        public E next() {
            return (E) array[cursor++];
        }
    }
}