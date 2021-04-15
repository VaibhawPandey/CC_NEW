package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week3;

public class LongestMountainInArray {
    public static void main(String[] args) {
        System.out.println(new LongestMountainInArray().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
    public int longestMountain(int[] A) {

        int n = A.length;
        int res = Integer.MIN_VALUE;
        int up[] = new int[n];
        int down[] = new int[n];

        for (int i = n-2; i >= 0; i--) {
            System.out.println(down[i] + "--" + down[i+1]);
            if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        }
        for (int i = 1; i < n; i++) {
            if (i > 0 && A[i] > A[i-1]) up[i] = up[i-1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }

        return res;
    }
}
