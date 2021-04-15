package main.java.Leetcode.WeeklyContest.WC221;

public class MaxEatenApples {
    public int eatenApples(int[] apples, int[] days) {

        int maxLen = Integer.MIN_VALUE, n = days.length;

        for (int i = 0; i < n; i++)
            maxLen = Math.max(maxLen, i + days[i]);

        int arr[] = new int[maxLen];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < i + days[i]; j++) {
               arr[j] += apples[i];
               if (arr[j] == apples[i])
                   apples[i]--;
            }
        }

        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            if (arr[i] > 0)
                res++;
        }

        return res;
    }
}
