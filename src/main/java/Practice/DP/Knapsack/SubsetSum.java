package main.java.Practice.DP.Knapsack;

import java.util.Scanner;


public class SubsetSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        // int target = scanner.nextInt();

        System.out.println(minimumDiff(arr, n));
    }

    // Minimum subset sum difference
    private static int minimumDiff(int arr[], int n) {

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int target = sum/2;

        boolean dp[][] = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (i == 0)
                    continue;

                if (j >= arr[i-1]) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        int s1 = 0;
        for (int i = dp[n].length - 1; i>=0; i--) {
            if (dp[n][i]) {
                s1 = i;
                break;
            }
        }

        return sum - 2 * s1;
    }

    // Subset with equal sum exist
    private static boolean equalSum(int arr[]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        return getStatus(arr, target, arr.length);
    }


    // Count of subset with given sum
    private static int getSum(int[] arr, int target, int n) {
        int dp[][] = new int[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == 0)
                    continue;

                if (j >= arr[i-1]) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        printArray(dp);

        return dp[n][target];
    }

    private static void printArray(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }



    private static boolean getStatus(int[] arr, int target, int n) {
         boolean dp[][] = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (i == 0)
                    continue;

                if (j >= arr[i-1]) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][target];
    }


}
