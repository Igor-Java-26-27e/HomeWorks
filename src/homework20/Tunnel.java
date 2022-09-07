package homework20;

import static homework20.MainClass.TUNNEL;

class Tunnel extends Stage {

    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {

            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

                TUNNEL.acquire(); //block the tunnel

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description);

                TUNNEL.release(); // release the tunnel

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}