package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPair {
    public static void main(String[] args) {
        new KDiffPair().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3);
    }
    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry entry: map.entrySet()) {
            if (k == 0) {
                if ((int) entry.getValue() >= 2)
                    count++;
            } else {
                if (map.containsKey((int) entry.getValue() + k))
                    count++;
            }
        }

        return count;
    }
}
