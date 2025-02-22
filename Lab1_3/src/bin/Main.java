package bin;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Sync s = new Sync();
        AtomicInteger i = new AtomicInteger();

        Thread p1 = new Thread(() -> {
            while (i.get() < 50) {
                synchronized (s) {
                    if (s.isPhase() == true) {
                        s.setX(Math.sin(s.getX()));
                        System.out.println(s.getX() );
                        s.setPhase(false);
                        s.notify();
                    } else {
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                i.getAndIncrement();
            }
        });
        Thread p2 = new Thread(() -> {
            while (i.get() < 50) {
            synchronized (s) {
                if(s.isPhase() == false) {
                    s.setX(Math.asin(s.getX()));
                    System.out.println(s.getX());
                    s.setPhase(true);
                    s.notify();
                }
                else {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
                i.getAndIncrement();
            }

        });

        p1.start();
        p2.start();

    }
}
