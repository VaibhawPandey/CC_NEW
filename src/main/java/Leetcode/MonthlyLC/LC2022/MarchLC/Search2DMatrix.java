package main.java.Leetcode.MonthlyLC.LC2022.MarchLC;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]{{}}, 3));
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length, n = matrix[0].length;
//        int l = 0, h = m - 1;
//
//        while (l < h) {
//            int mid = (l + h)/2;
//
//            if (matrix[0][mid] >= target) l = mid;
//            else h = mid - 1;
//        }
//
//        int k = 0;
//        h = n - 1;
//
//        while (k < h) {
//            int mid = (k + h)/2;
//
//        }
//    }


    // Alternative
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        int m = matrix.length, n = matrix[0].length;

        while(i < m && matrix[i][j] <= target) i++;
        if (i != 0) i--;

        while(j < n && matrix[i][j] <= target) {
            if (matrix[i][j] == target) return true;
            j++;
        }

        return false;
    }
}
