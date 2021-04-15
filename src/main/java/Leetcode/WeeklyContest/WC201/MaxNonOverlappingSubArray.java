package main.java.Leetcode.WeeklyContest.WC201;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNonOverlappingSubArray {

    public int maxNonOverlapping(int[] nums, int target) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            if (nums[0] == target) return 1;
            else return 0;

        List<Integer> list = new ArrayList<>();
        list.add(0);

        int count = 0, i = 0, sum = 0;
        while (i < nums.length) {

            sum += nums[i];
            i++;
            if (list.contains(sum - target)) {
                count++;
                list = new ArrayList<>();
                list.add(0);
                continue;
            }

            list.add(sum);
        }

        return count;
    }
}
