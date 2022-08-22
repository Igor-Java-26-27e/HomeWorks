package lesson18;

public class PrintABWaitNotify {
    private final Object mon = new Object();
    private char letter = 'A';

    public static void main(String[] args) {
        PrintABWaitNotify pab = new PrintABWaitNotify();
        new Thread(() -> pab.printA()).start();
        new Thread(() -> pab.printB()).start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (letter != 'A') {
                        mon.wait();
                    }
                    Thread.sleep(250);
                    System.out.print("A");
                    letter = 'B';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (letter != 'B') {
                        mon.wait();
                    }
                    Thread.sleep(250);
                    System.out.print("B");
                    letter = 'A';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
