package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week3;

import java.util.HashSet;
import java.util.Set;

public class MaxXOR {
    public int findMaximumXOR(int[] nums) {

        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {

            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();

            for (int num: nums)
                set.add(num & mask);

            int tmp = max| (1 << i);
            for (int num: nums) {
                if (set.contains(tmp ^ num))
                    max = tmp;
            }
        }

        return max;
    }
}
