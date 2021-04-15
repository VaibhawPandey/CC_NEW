package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week3;

public class Searchin2DMatrix {
    public static void main(String[] args) {
        System.out.println(new Searchin2DMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;

        if (m == 0)
            return false;

        int n = matrix[0].length;
        int left = 0, right = m - 1;
        int row = -1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (matrix[mid][0] == target || matrix[mid][n-1] == target)
                return true;

            if (matrix[mid][0] < target && matrix[mid][n-1] >= target) {
                row = mid;
                break;
            }

            if (matrix[mid][0] > target)
                right = mid - 1;
            else
                left = mid;
        }

        if (row == -1)
            return false;

        left = 0; right = n - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (matrix[row][mid] == target)
                return true;

            if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid;
        }

        return false;
    }
}
