package org.knuba.task21;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task21 {
    private static int n = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            Runnable runnable = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\tFields: " + Arrays.toString(Thread.currentThread().getClass().getFields())
                    );
                }
            });
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}