package org.knuba.task24;

public class Task24 {
    static boolean allowed = true;

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadA(), "A");
        a.start();
    }

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            Thread b;
            while (true) {
                allowed = true;
                getState(allowed);

                try {
                    b = new Thread(new ThreadB(), "B");
                    b.start();
                    Thread.sleep(100);
                    allowed = false;
                    b.join();
                    getState(allowed);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        private void getState(boolean allowed) {
            String state;
            if (allowed) {
                state = "дозволено";
            } else {
                state = "не дозволено";
            }
            System.out.println("Стан потоку " + Thread.currentThread().getName().toUpperCase()
                    + ": " + state);
        }
    }

    public static class ThreadB implements Runnable {

        @Override
        public void run() {
                if (allowed) {
                    System.out.println("Потік " + Thread.currentThread().getName().toUpperCase()
                            + " починає відлік 10 мілісекунд.");

                    try {
                        for (int i = 10; i > 0; i--) {
                            System.out.println(i);
                            Thread.sleep(i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
