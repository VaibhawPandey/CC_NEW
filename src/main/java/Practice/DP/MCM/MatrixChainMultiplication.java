package main.java.Practice.DP.MCM;

public class MatrixChainMultiplication {
    public int matrixChainMultiplication(int arr[], int i, int j) {
        if (i >= j) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int tempAns = matrixChainMultiplication(arr, i, k) + matrixChainMultiplication(arr, k + 1, j)
                    + arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, tempAns);
        }

        return min;
    }
}
