package main.java.Codechef.DP;

import java.util.Scanner;

public class Billiards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();

            if (n < 2) {
                System.out.println(0);
                continue;
            }

            if (n < 4) {
                System.out.println(1);
                continue;
            }

            int dp[] = new int[n + 1];
            dp[2] = 1;
            dp[3] = 1;

            for (int j = 4; j <= n; j++) {
                dp[j] = (dp[j-2] + dp[j - 3]) % 1000000009;
            }

            System.out.println(dp[n]  % 1000000009);
        }
    }
}
