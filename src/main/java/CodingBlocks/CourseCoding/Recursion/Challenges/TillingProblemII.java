package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class TillingProblemII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long dp[] = new long[100001];
            for (int i = 0; i < m; i++)
                dp[i] = 1;

            for (int i = m; i <= n; i++)
                dp[i] = (dp[i-1] + dp[i - m])%1000000007;

            System.out.println(dp[n]);
        }

    }

//    private static long numberofWays(int n, int m) {
//        if (n <= m) return 1;
//
//        if (dp[n] != 0) return dp[n];
//
//        return dp[n] = (dp[n-1] != 0 ? dp[n-1]: numberofWays(n-1, m) +
//                dp[n-m] != 0 ? dp[n-m]: numberofWays(n-m, m))%1000000007;
//    }
}
