package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class CountBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int maxN = 90;
        long dp[][] = new long[maxN + 1][2];
        dp[1][0] = 1; dp[1][1] = 1;

        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        while (t-- > 0) {
            int k = scanner.nextInt();
            System.out.println(dp[k][0] + dp[k][1]);
        }
        scanner.close();
    }
}
