package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] >= 0)
                nums[nums[i] - 1] *= -1;
            else
                out.add(Math.abs(nums[i]));
        }

        return out;
    }
}
