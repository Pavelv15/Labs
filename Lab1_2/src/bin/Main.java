package bin;

public class Main {
    static boolean chek = false;
    public static void main(String[] args) throws InterruptedException {
        final int j = 1;
        final int k = 101;


        Thread p1 = new Thread(() -> { for (int i = j; i <= j + 99; i++ )
            if( i == 50) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.printf("%s %d \n", Thread.currentThread().getName(),i);
            }
            chek = true;
        }
                , "Поток 1");

        Thread p2 = new Thread(() -> { for (int i = k; i <= k + 99; i++ )
            if(chek == false)  {
                try {
                    p1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
            System.out.printf("%s %d \n", Thread.currentThread().getName(),i);}},"Поток 2");



        p1.start();
        p2.start();
        //Эксперименты
/**

        p1.start();
        Thread.sleep(300);
       p2.start();
        p2.start();
        Thread.sleep(300);
        p1.start();
 **/
        p2.join();
        System.out.println(Thread.currentThread().getName());


    }
}
