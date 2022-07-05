package lesson8;

import java.util.Iterator;

public class Lesson8 {
    public static void main(String[] args) {
        RubberList rl = new RubberList();
        System.out.println(rl);
        rl.offer(1);
        rl.offer(2);
        rl.offer(51);
        rl.add(123);
        System.out.println(rl);
        for (Object item : rl) {
            System.out.println(item);
        }
        System.out.println("pop: " + rl.poll());
        System.out.println("pop: " + rl.pop());
        System.out.println("pop: " + rl.pop());
        System.out.println("pop: " + rl.pop());
        System.out.println(rl);
    }
}

class RubberList implements Iterable {

    private int size = 0;

    private Node first;

    private Node last;

    //queue method
    public void offer(int value) {
        if (first == null) {
            first = new Node(null, value, null);
        } else if (last == null) {
            last = first;
            first = new Node(null, value, last);
            last.prev = first;
        } else {
            Node newFirst = new Node(null, value, first);
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    public int poll() {
        return pop();
    }

    //stack method

    public void push(int value) {
        add(value);
    }


    public int peek() {
        return last != null ? last.item : first.item;
    }

    public Integer pop() {
        if (size > 0) {
            int lastValue = last != null ? last.item : first.item;
            remove(size - 1);
            return lastValue;
        }
        return null;
    }

    //standart method
    public void add(int value) {
        if (first == null) {
            first = new Node(null, value, null);
        } else if (last == null) {
            last = new Node(first, value, null);
            first.next = last;
        } else {
            Node newLast = new Node(last, value, null);
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public boolean remove(int idx) {
        if (idx < size) {
            size--;
            if (idx == 0) {
                if (first.next == null) {
                    first = null;
                    return true;
                }
                Node newFirst = first.next;
                newFirst.prev = null;
                first = newFirst;
                return true;
            } else if (idx == size) {
                Node newLast = last.prev;
                newLast.next = null;
                last = newLast;
            } else {
                int index = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (idx == index) {
                        Node prev = cursor.prev;
                        Node next = cursor.next;
                        prev.next = next;
                        next.prev = prev;
                        cursor.next = null;
                        cursor.prev = null;
                        return true;
                    }
                    cursor = cursor.next;
                    index++;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node cursor = first;
        while (cursor != null) {
            sb.append(cursor.item);
            if (cursor.next != null) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator {
        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Object next() {
            int value = cursor.item;
            cursor = cursor.next;
            return value;
        }
    }

    private class Node {
        int item;
        Node next;
        Node prev;

        public Node(Node prev, int item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
