package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week4;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;
        if (m == 0)
            return new int[]{};

        int n = matrix[0].length;
        int res[] = new int[m*n];

        int row = 0, col = 0, d = 0;
        int mov[][] = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {

            res[i] = matrix[row][col];
            row += mov[d][0];
            col += mov[d][1];

            if (row >= m) { row = m-1; col += 2; d = 1-d; }
            if (col >= n) { col = n-1; row += 2; d = 1-d; }
            if (row < 0) {row = 0; d = 1-d; }
            if (col < 0) {col = 0; d = 1-d; }
        }

        return res;
    }
}
