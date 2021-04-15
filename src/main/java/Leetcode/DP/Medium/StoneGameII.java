package main.java.Leetcode.DP.Medium;

public class StoneGameII {
    public static void main(String[] args) {
        System.out.println(new StoneGameII().stoneGameII(new int[]{1, 2, 3, 4, 5, 100}));
    }

    // int alexSum = 0;
    public int stoneGameII(int[] piles) {

       int n = piles.length;
       int memo[][] = new int[n][n];

       // int subsetSum[] = new int[n];
       // subsetSum[n-1] = piles[n-1];
        for (int i = n - 2; i >= 0; i--)
            piles[i] += piles[i + 1];

        return solve(piles, 0, 1, memo);
    }

    private int solve(int[] subsetSum, int index, int m, int[][] memo) {

        if (subsetSum.length <= (index + 2 * m)) return subsetSum[index];

        if (memo[index][m] > 0) return memo[index][m];

        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= 2 * m; k++) {
            int current = subsetSum[index] - subsetSum[index + k];
            res = Math.max(res, current + subsetSum[index + k] - solve(subsetSum, index + k, Math.max(k, m), memo));
        }

        return memo[index][m] = res;
    }


//    private void solve(int[] piles, int index, int M, int partSum, int n) {
//
//        if (index >= n) {
//            alexSum = Math.max(alexSum, partSum);
//            return;
//        }
//
//        for (int i = index; i <= index + M && i < n; i++) {
//            partSum += piles[i];
//            solve(piles, i + 1, (i - index + 1) * 2, partSum, n);
//        }
//    }


//    public int stoneGameII(int[] piles) {
//
//        int n = piles.length;
//        int alexSum = 0, tempSum = 0;
//
//        if (n <= 2) {
//            return piles[0];
//        }
//
//        for (int i = 0; i < 2; i++) {
//
//            int index = i + 1, last = 0,  x = i + 1;
//            int temp = n - index;
//            tempSum = 0;
//
//            while (temp > 0) {
//
//                for (int j = last; j < index && j < n; j++)
//                    tempSum += piles[j];
//
//                x *= 2;
//                index += x;
//                temp = n - index;
//                last = index;
//                x *= 2;
//                index += x;
//            }
//
//            alexSum = Math.max(alexSum, tempSum);
//        }
//
//        return alexSum;
//    }
}
