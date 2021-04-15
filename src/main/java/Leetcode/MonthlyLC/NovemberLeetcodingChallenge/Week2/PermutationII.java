package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationII {
    List<List<Integer>> res;
    int dp[][];
    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<>();
        dp = new int[nums.length][nums.length];
        // res.add(new ArrayList<>());

        permute(nums, 0, nums.length);
        return res;
    }

    private void permute(int[] nums, int index, int n) {
        if (index == n) {
            // ArrayList<Integer> subRes = Arrays.asList(nums);
            res.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isCheck(nums, index, i)) {
                nums = swap(nums, index, i);
                permute(nums, index + 1, n);
                nums = swap(nums, index, i);
            }
        }

    }

    private int[] swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
        return nums;
    }

    private boolean isCheck(int[] nums, int index, int n) {
        for (int i = index; i < n; i++) {
            if (nums[i] == nums[n])
                return false;
        }

        return true;
    }
}
