package bin;

import java.util.concurrent.*;
import java.util.function.DoubleFunction;

public class Main {
    public static final int STEPS = 10000000;
    public static final int TASKS = 10;

    public static double singleThread(DoubleFunction<Double> f, double a, double b, int steps) {
        double w = (b - a) / steps;
        double summa = 0d;

        for (int i = 0; i < steps; i++) {
            double x = a + w * i + w / 2;
            double y = f.apply(x);
            summa += w * y;
        }

        return summa;

    }

    public static double multiThread(DoubleFunction<Double> f, double a, double b) throws ExecutionException, InterruptedException {
        double h = (b-a) / TASKS;
        ExecutorService pool = Executors.newWorkStealingPool();
        Future<Double>[] tasks = new Future[TASKS];
        for (int i = 0; i < TASKS; i++) {
            final double ax = a + h*i;
            final double bx = ax + h;
            tasks[i] = pool.submit( ()-> singleThread(f, ax, bx, STEPS/TASKS) );
        }

        double summa  = 0d;
        for (Future<Double> task : tasks)
            summa += task.get();

        pool.shutdown();
        return summa;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 3;
        int b = 6;

        Long t1 = System.currentTimeMillis();
        double r = multiThread(Math::sin,0,Math.PI/2);
        Long t2 = System.currentTimeMillis();
        System.out.println("Результат вычисления: " + r + ". Время выполнения: " + (t2-t1));

    }


}








