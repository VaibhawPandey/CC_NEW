package main.java.Codechef.MonthlyContest.December2020Contest;

import java.util.Scanner;

public class VaccineProduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d1 = scanner.nextInt(), v1 = scanner.nextInt();
        int d2 = scanner.nextInt(), v2 = scanner.nextInt();
        int p = scanner.nextInt();

        int smaller = d1 < d2 ? d1: d2;
        int diff = Math.abs(d1-d2);
        int v = smaller == d1 ? v1: v2;
        // int res = 0;

        if (v * diff >= p) {
            int k = (int) Math.ceil((double) p/(double) v);
            System.out.println(smaller + k - 1);
        } else {
            p -= (v * diff);
            int k = (int) Math.ceil( (double) p/ (double) (v1 + v2));
            System.out.println(smaller + diff + k - 1);
        }
    }
}
