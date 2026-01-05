package org.example;

public class PrintPattern {
    public static void main(String[] args) {
        int n = 3;
        int m=n;
        while (m > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(n-i);
                }
            }
            m--;
            System.out.println();
        }
    }
}
