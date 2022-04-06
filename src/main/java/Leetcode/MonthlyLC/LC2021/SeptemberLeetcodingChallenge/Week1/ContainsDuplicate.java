package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        new ContainsDuplicate().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            long referredNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = referredNum/ ((long) t + 1);

            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket - 1) && referredNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - referredNum <= t))
                return true;

            if (map.size() >= k) {
                long firstBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) (t + 1));
                map.remove(firstBucket);
            }

            map.put(bucket, referredNum);
        }

        return false;
    }
}
