package lesson18;

public class Counter {
    private int value;

    private Object monitorValue = new Object(); // POJO Plain Old Java Object


    public Counter(){
        this.value=0;
    }

    public void increment(){  //synchronized se scoate din Method daca sincronizam doar o parte din cod
        synchronized (monitorValue){
            value++;
        }
        //TODO
    }

    public void decrement(){
        synchronized (monitorValue){
            value--;
        }
        //TODO
    }

    @Override
    public String toString() {
        return "Counter{" +
                "value=" + value +
                '}';
    }
}
