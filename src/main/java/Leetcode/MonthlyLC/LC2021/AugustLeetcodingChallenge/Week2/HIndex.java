package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int left = 0, right = citations.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (citations[mid] < citations.length - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return citations.length - left;
    }
}
