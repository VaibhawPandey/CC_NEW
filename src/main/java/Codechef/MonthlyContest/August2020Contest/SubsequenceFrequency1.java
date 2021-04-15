package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Scanner;

public class SubsequenceFrequency1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int p = 0; p < t; p++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int minVal = Integer.MAX_VALUE, maxCount = Integer.MIN_VALUE;
            int arrCount[] = new int[n + 1];
            int res[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                // Pick ending point
                for (int j = i; j < n; j++) {
                    // Print subarray between current starting
                    // and ending points
                    minVal = Integer.MAX_VALUE;
                    maxCount = Integer.MIN_VALUE;
                    arrCount = new int[n + 1];
                    for (int k = i; k <= j; k++) {
                        arrCount[arr[k]]++;

                        if (arrCount[arr[k]] > maxCount) {
                            maxCount = arrCount[arr[k]];
                            minVal = arr[k];
                        }

                        if (arrCount[arr[k]] == maxCount)
                            minVal = Math.min(arrCount[arr[k]], minVal);
                    }

                    res[minVal] = (res[minVal] + 1) % 1000000007;
                }
            }



        }
    }
}
