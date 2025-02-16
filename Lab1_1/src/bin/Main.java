package bin;

public class Main {
    public static void main(String[] args) {
        int j = 1;
        int k = 101;
        Thread p1 = new Thread(() -> { for (int i = j; i <= j + 99; i++ )
            if( i == 50) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
            System.out.printf("%s %d \n", Thread.currentThread().getName(),i); }  },"Поток 1");

        Thread p2 = new Thread(() -> { for (int i = k; i <= k + 99; i++ )
            System.out.printf("%s %d \n", Thread.currentThread().getName(),i);},"Поток 2");
        p1.start();
        p2.start();


    }
}
