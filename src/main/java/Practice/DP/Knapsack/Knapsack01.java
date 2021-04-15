package main.java.Practice.DP.Knapsack;

import java.util.Scanner;

public class Knapsack01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int w[] = new int[n];
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int W = scanner.nextInt();
        System.out.println(kS(w, v, W, n));
    }

    private static int kS(int[] w, int[] v, int W, int n) {

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (w[i-1] <= j) {
                    dp[i][j] = Math.max(v[i - 1] + dp[i-1][j - w[i-1]], dp[i-1][j]);
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.print(i == 0 ? 0 : w[i-1] +":- ");
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[n][W];
    }
}
