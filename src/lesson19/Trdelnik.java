package lesson19;

public class Trdelnik {
    private int countTdlo = 0;
    private Object mon = new Object();

    public static void main(String[] args) throws InterruptedException {
        Trdelnik trdlo = new Trdelnik();
        Thread cook = new Thread(() -> trdlo.cookTrdlo());
        Thread buy = new Thread(() -> trdlo.buyTrdlo());
        cook.start();
        buy.start();
        cook.join();
        buy.join();
        System.out.println(trdlo.countTdlo);
    }

    private void cookTrdlo() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                synchronized (mon) {
                    while (countTdlo == 1) {
                        mon.wait();
                    }
                    System.out.println("Trdelnik is cooked");
                    countTdlo++;
                    mon.notify();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void buyTrdlo() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                synchronized (mon) {
                    if (countTdlo == 0) {
                        mon.wait();
                    }
                    if (countTdlo == 1) {
                        countTdlo--;
                        System.out.println("Client is happy");
                    } else if (countTdlo > 1) {
                        countTdlo--;
                        System.out.println("Client is not so happy");
                    } else {
                        System.out.println("Client is very unhappy");
                    }
                    mon.notify();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
