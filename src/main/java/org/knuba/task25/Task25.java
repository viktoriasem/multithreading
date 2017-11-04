package org.knuba.task25;

public class Task25 {
    private static final int ROWS_A = 200;
    private static final int COLS_A = 100;
    private static final int ROWS_B = COLS_A;
    private static final int COLS_B = ROWS_A;

    private static final int IN_A = 5;
    private static final int IN_B = 5;
    
    private static int[][] a;
    private static int[][] b;
    private static int[][] c;

    public static void main(String[] args) throws Exception {
        a = amtrx();
        b = bmtrx();
        c = new int[a.length][b[0].length];

        Thread m1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int n = b[0].length;
                int k = (a.length) / 4;

                for (int i = 0; i <= k; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int l = 0; l < b.length; l++) {
                            c[i][j] = c[i][j] + a[i][l] * b[l][j];

                        }

                    }

                }
            }
        });
        Thread m2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int n = b[0].length;
                int k = (a.length) / 2 + 1;
                int s = ((a.length) / 4) + 1;

                for (int i = s; i < k; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int l = 0; l < b.length; l++) {
                            c[i][j] = c[i][j] + a[i][l] * b[l][j];

                        }

                    }

                }
            }
        });
        Thread m3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int n = b[0].length;
                int k = ((3 * (a.length)) / 4) + 1;
                int s = (a.length) / 2 + 1;

                for (int i = s; i < k; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int l = 0; l < b.length; l++) {
                            c[i][j] = c[i][j] + a[i][l] * b[l][j];

                        }

                    }

                }
            }
        });
        Thread m4 = new Thread(new Runnable() {
            @Override
            public void run() {
                int m = a.length;
                int n = b[0].length;
                int k = ((3 * (a.length)) / 4) + 1;


                for (int i = k; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int l = 0; l < b.length; l++) {
                            c[i][j] = c[i][j] + a[i][l] * b[l][j];

                        }

                    }

                }
            }
        });
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m1.join();
        m2.join();
        m3.join();
        m4.join();

        printOutmtrx(c);
    }


    public static int[][] amtrx() {
        int[][] matrix = new int[ROWS_A][COLS_A];
        for (int i = 0; i < ROWS_A; i++) {
            for (int j = 0; j < COLS_A; j++) {
                matrix[i][j] = IN_A;
            }
        }
        return matrix;
    }

    public static int[][] bmtrx() {
        int[][] matrix = new int[ROWS_B][COLS_B];
        for (int i = 0; i < ROWS_B; i++) {
            for (int j = 0; j < COLS_B; j++) {
                matrix[i][j] = IN_B;
            }
        }
        return matrix;
    }

    public static void printOutmtrx(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        String str = "|\t";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += matrix[i][j] + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }
    }

}