package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week1;

public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {

        int result = 0;
        for (int i = - A.length + 1; i < A.length; i++) {
            for (int j = - B.length + 1; j < B.length; j++) {
                result = Math.max(result, getCount(A, B, i, j));
            }
        }

        return result;
    }

    private int getCount(int[][] a, int[][] b, int i, int j) {

        int counter = 0;
        for (int k = 0; k < a.length; k++) {
            for (int l = 0; l < b.length; l++) {

                if (i + k < 0 || i + k >= a.length || j + l < 0 || j + l >= b.length)
                    continue;

                if (a[k][l] == a[i][j])
                    counter++;
            }
        }

        return counter;
    }
}
