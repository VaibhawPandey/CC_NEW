package main.java.Codechef.MonthlyContest.September2020Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CornavirusSpread {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int v[] = new int[n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (j == k) continue;

                    if (j < k && arr[j] > arr[k]) {
                        int diff = arr[j] - arr[k];
                        if ((k - j) % diff == 0)
                            v[j]++;
                    } else if (j > k && arr[k] > arr[j]) {
                        int diff = arr[k] - arr[j];
                        if ((j - k) % diff == 0)
                            v[j]++;
                    }
            }
            }

            int maxCount = Integer.MIN_VALUE, minCount = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                maxCount = Math.max(maxCount, v[j] + 1);
                minCount = Math.min(minCount, v[j] + 1);
            }

            System.out.println(minCount +" " + maxCount);

    }
    }
}
