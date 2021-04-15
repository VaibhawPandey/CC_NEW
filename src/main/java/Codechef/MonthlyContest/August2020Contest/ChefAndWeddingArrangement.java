package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChefAndWeddingArrangement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int arr[] = new int[n];
            // int familyCount[] = new int[101];
            int tableSize = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                tableSize = Math.max(tableSize, arr[j]);
            }

            int col[][] = new int[n][n];
            int tableCount[] = new int[tableSize + 1];

            for (int j = 0; j < n; j++) {
                Arrays.fill(tableCount, 0);
                for (int l = j; l < n; l++) {

                    col[j][l] = l == 0 ? 0: col[j][l-1];
                    if (tableCount[arr[l]] != 0) {
                        if (tableCount[arr[l]] == 1)
                            col[j][l]++;

                        col[j][l]++;
                    }

                    tableCount[arr[l]]++;
                }
            }

            int dp[][] = new int[tableSize + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                dp[1][j] = col[0][j-1];
            }

            for (int j = 2; j <= tableSize; j++) {
                for (int l = 2; l <= n; l++) {

                    int best = Integer.MAX_VALUE;
                    for (int m = 1; m < l; m++) {
                        best = Math.min(best, dp[j-1][m] + col[m][l-1]);
                    }

                    dp[j][l] = best;
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int table = 1; table <= tableSize; table++) {
                ans = Math.min(ans, k * table + dp[table][n]);
            }

            System.out.println(ans);
        }
    }

//    private static int getResult(int[] arr, int left, int right, int k, int totalFamilyCount) {
//
//        if (k > totalFamilyCount) {
//            if (totalFamilyCount == 0)
//            return k;
//
//            return k + totalFamilyCount + 1;
//        }
//
//        if (left > right)
//            return 0;
//
//        if (left == right)
//            return k;
//
//        int mid = (left + right) / 2;
//        int totalFamilyCount1 = 0;
//        int totalFamilyCount2 = 0;
//        int familyCount[] = new int[101];
//        int i = left;
//        while (i <= mid) {
//
//            familyCount[arr[i]]++;
//
//            if (familyCount[arr[i]] > 1)
//                totalFamilyCount1++;
//
//            i++;
//        }
//        familyCount = new int[101];
//        while (i <= right) {
//
//            familyCount[arr[i]]++;
//
//            if (familyCount[arr[i]] > 1)
//                totalFamilyCount2++;
//
//            i++;
//        }
//
//        return getResult(arr, left, mid, k, totalFamilyCount1) +
//                getResult(arr, mid + 1, right, k, totalFamilyCount2);
//    }
}
