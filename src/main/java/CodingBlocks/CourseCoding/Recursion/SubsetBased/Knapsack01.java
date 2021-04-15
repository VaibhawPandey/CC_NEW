package main.java.CodingBlocks.CourseCoding.Recursion.SubsetBased;

import java.util.Scanner;

public class Knapsack01 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int wt[] = new int[n];
        int price[] = new int[n];

        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
            price[i] = scanner.nextInt();
        }
        int W = scanner.nextInt();
        System.out.println(recurKnap(wt, price, 0, W, n, 0));
        scanner.close();
    }

    private static int recurKnap(int[] wt, int[] price, int index, int W, int n, int p) {
        if (index == n) {
            max = Math.max(p, max);
            return max;
        }

        int inc = (wt[index] <= W) ? recurKnap(wt, price, index + 1, W - wt[index], n, p + price[index]): Integer.MIN_VALUE;
        int exc = recurKnap(wt, price, index + 1, W, n, p);

        return Math.max(inc, exc);
    }
}
