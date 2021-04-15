package main.java.Leetcode.WeeklyContest.WC217;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MostCompetitive {
    public static void main(String[] args) {
        new MostCompetitive().mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4);
    }
    public int[] mostCompetitive(int[] nums, int k) {

        int n = nums.length;

        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = -1;
        for (int i = 0; i <= n - k; i++) {
            if (minNumber > nums[i]) {
                minNumber = nums[i];
                minNumberIndex = i;
            }
        }

        if (k == 1)
            return new int[]{minNumber};

        int res[] = new int[k];
        // solve(nums, minNumberIndex + 1, k, 1, subList);
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = minNumber;
        int size = 1;

        for (int i = minNumberIndex + 1; i < nums.length; i++) {
            if (res[size] > nums[i] && (nums.length - i) >= k-size) {
                res[size] = nums[i];
                size++;
            }
        }

        return res;
    }

//    private void solve(int[] nums, int minNumberIndex, int k, int size, int subList[]) {
//
//        if (size == k) {
//            if (res == null)
//                res =  subList.clone();
//            else {
//                boolean isSmaller = true;
//                for (int i = 0; i < k; i++) {
//                    if (res[i] < subList[i]) {
//                        isSmaller = false;
//                        break;
//                    }
//                }
//
//                if (isSmaller)
//                    res = subList.clone();
//            }
//            return;
//        }
//
//        if (minNumberIndex >= nums.length || (nums.length - minNumberIndex + size) < k)
//            return;
//
//        solve(nums, minNumberIndex + 1, k, size, subList);
//        subList[size] = nums[minNumberIndex];
//        solve(nums, minNumberIndex + 1, k, size + 1, subList);
//
//        }
    }
