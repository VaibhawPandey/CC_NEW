package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week4;


public class SlidingWindowMax {
    public static void main(String[] args) {
        new SlidingWindowMax().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int res[] = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                max = Math.max(max, nums[i]);
                if (i == k-1) {
                    res[idx] = max;
                    idx++;
                }
                continue;
            }
            if (nums[i-k] == max) {
                int tempMax = Integer.MIN_VALUE;
                for (int j = i-k+1; j <= i; j++)
                    tempMax = Math.max(tempMax, nums[j]);

                max = tempMax;
            }

            max = Math.max(max, nums[i]);
            res[idx] = max;
            idx++;
        }

        return res;
    }
}
