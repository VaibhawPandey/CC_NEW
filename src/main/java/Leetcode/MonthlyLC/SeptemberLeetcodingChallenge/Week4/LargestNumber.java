package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String arr[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String ab = str1 + str2;
                String ba = str2 + str1;
                return ba.compareTo(ab);
            }
        });

        if (arr[0].charAt(0) == '0')
            return "0";

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            res.append(arr[i]);

        return res.toString();
    }
}
