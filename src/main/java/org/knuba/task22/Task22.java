package org.knuba.task22;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task22 {
    static int n = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            Runnable worker = new Thread(new Runnable() {
                @Override
                public void run() {
                    ArrayList<String> words = new ArrayList<>();
                    int count = 0;

                    String strWord = "class";
                    for (int c = 0; c < 6; c++) {
                        words.add(strWord);
                    }
                    for (int k = 0; k < words.size(); k++) {
                        if (words.get(k).equalsIgnoreCase(strWord)) {
                            count = (k + 1);
                        }
                    }
                    System.out.println("class found in thread " + count);
                }
            });
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
