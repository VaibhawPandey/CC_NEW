package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week2;

import java.util.Stack;

public class FlipImage {
    public static void main(String[] args) {
        new FlipImage().flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
    public int[][] flipAndInvertImage(int[][] A) {

        int m = A.length;
        if (m == 0)
            return A;

        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int s = 0, e = n - 1;
            while (s < e) {
                int temp = A[i][e] == 0 ? 1 : 0;
                A[i][e] = A[i][s] == 0 ? 1: 0;
                A[i][s] = temp;
                s++; e--;
            }
            if (s == e)
                A[i][e] = A[i][e] == 0 ? 1: 0;
        }

        return A;
    }
}
