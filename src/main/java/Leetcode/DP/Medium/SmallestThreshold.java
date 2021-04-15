package main.java.Leetcode.DP.Medium;

public class SmallestThreshold {
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 0, right = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
            right = Math.max(right, nums[i]);

        while (left < right) {

            int mid = (left + right)/2, sum = 0;
            for (int i = 0; i < nums.length; i++)
                sum += Math.ceil((double)(nums[i]/mid));

            if (sum <= threshold) {
                right = mid;
                res = Math.min(res, mid);
            } else
                left = mid + 1;
        }

        return res;
    }
}
