package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week4;

import java.util.*;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {

        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        if (n == 0)
            return res;

        for (int num: nums) {
            if (num == num1) {
                count1++;
                continue;
            }
            if (num == num2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                num1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                num2 = num;
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;

        for (int num: nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                   count2++;
        }

        if (count1 > n/3)
            res.add(num1);

        if (count2 > n/3)
            res.add(num2);

        return res;
    }
}
