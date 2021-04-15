package main.java.Leetcode.WeeklyContest.WC216;

public class WaytoMakeFairPlay {
    public static void main(String[] args) {
        new WaytoMakeFairPlay().waysToMakeFair(new int[]{2, 1, 6, 4});
    }
    class Pair {
        int eSum = 0;
        int oSum = 0;

        Pair(int eSum, int oSum) {
            this.eSum = eSum;
            this.oSum = oSum;
        }
    }

    public int waysToMakeFair(int[] nums) {

        int res = 0;
        if (nums.length == 0)
            return res;
        int n = nums.length;
        Pair preSum[] = new Pair[n];
        Pair suffSum[] = new Pair[n];

        int eSum = 0, oSum = 0;
        for (int i = 0; i < n; i++) {
            preSum[i] = new Pair(eSum, oSum);
            if (i % 2 == 0)
                eSum += nums[i];
            else
                oSum += nums[i];
        }

        eSum = 0; oSum = 0;
        for (int i = n-1; i >= 0; i--) {
            suffSum[i] = new Pair(eSum, oSum);
            if (i % 2 == 0)
                eSum += nums[i];
            else
                oSum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            int tempOddSum = preSum[i].oSum + suffSum[i].eSum;
            int tempEvenSum = preSum[i].eSum + suffSum[i].oSum;

            if (tempEvenSum == tempOddSum)
                res++;
        }

        return res;
    }
}
