package org.knuba.task23;

import java.util.ArrayList;

public class Task23 {


    public static void main(String[] args) throws InterruptedException {
        int size = 5;
        ArrayList<String> queue = new ArrayList<>(size);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 244;
                while (true) {
                    try {
                        Thread.sleep(100);
                        i = addToQueue(size, queue, i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    int i = 999;
                    while (true) {
                        try {
                            Thread.sleep(100);
                            i = addToQueue(size, queue, i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "b");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    while (true) {
                        try {
                            Thread.sleep(100);
                            System.out.println("\n" + Thread.currentThread().getName() + " видаляє з черги");
                            try {
                                queue.remove(0);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }

                            for (int i = 0; i < queue.size(); i++) {
                                System.out.println("queue(" + i + ") = " + queue.get(i));
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "c");

        a.start();
        b.start();
        c.start();

        a.join();
        b.join();
        c.join();
    }

    public static int addToQueue(int queueSize, ArrayList<String> queue, int i) {
        if (queue.size() < queueSize) {
            System.out.println("\n" + Thread.currentThread().getName() + " додає у чергу");
            queue.add("element" + i + " of thread " + Thread.currentThread().getName());
            i++;
        }
        return i;
    }
}
