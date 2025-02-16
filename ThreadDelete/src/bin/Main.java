package bin;

public class Main {
    public static void main(String[] args) {
        Thread p1 = new Delete();
        Thread p2 = new Delete();
        p1.start();
        p2.start();
    }



}
