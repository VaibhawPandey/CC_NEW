package main.java.Leetcode.WeeklyContest.WC204;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthofSubArray {

    public static void main(String[] args) {
        System.out.println(new MaxLengthofSubArray().getMaxLen(new int[]{0,1,-2,-3,-4}));
    }
    public int getMaxLen(int[] nums) {

        List<Integer> positionofNN = new ArrayList<>();
        int noofNegativeNumber = 0;
        int res = 0;
        int last0Position = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {

                if (noofNegativeNumber == 1) {
                    res = Math.max(res, i - positionofNN.get(0));
                } else if (noofNegativeNumber % 2 != 0) {
                    res = Math.max(res, i - positionofNN.get(positionofNN.size() - 2));
                }

                noofNegativeNumber = 0;
                positionofNN.clear();
                last0Position = i;
            } else if (nums[i] < 0) {
                noofNegativeNumber++;

                if (noofNegativeNumber % 2 == 0)
                    res = last0Position == -1 ? i + 1: i - last0Position;

                if (noofNegativeNumber == 1)
                    res = last0Position == -1 ? i: i - last0Position - 1;

                positionofNN.add(i);
            } else {
                if (noofNegativeNumber % 2 == 0)
                    res++;
            }
        }

        if (noofNegativeNumber == 1) {
            res = Math.max(res, positionofNN.size() - 1 - positionofNN.get(0));
        } else if (noofNegativeNumber % 2 != 0) {
            res = Math.max(res, positionofNN.size() - 1 - positionofNN.get(positionofNN.size() - 2));
        }


        return res;

    }
}
