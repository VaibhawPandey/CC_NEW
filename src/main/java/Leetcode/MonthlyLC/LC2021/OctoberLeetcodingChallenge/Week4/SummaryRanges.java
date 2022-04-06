package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        int start = -1, end = -1;

        for (int i = 0; i < nums.length; i++) {
            start = nums[i]; end = nums[i];

            while ((i + 1 < nums.length) && nums[i+1] == end + 1) {
                end++;
                i++;
            }

            if (start == end)
                res.add(String.valueOf(start));
            else
                res.add(start +"->" + end);
        }

        return res;
    }
}
