package main.java.Codechef.DP;

import java.util.Scanner;

public class CountSubArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];
            int dp[] = new int[n];
            int res = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                dp[j] = 1;

                if (j != 0 && arr[j] >= arr[j-1])
                    dp[j] = 1 + dp[j-1];

                res += dp[j];
            }


            System.out.println(res);
        }

    }
}
