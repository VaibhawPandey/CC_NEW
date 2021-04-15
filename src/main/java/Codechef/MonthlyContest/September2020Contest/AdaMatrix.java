package main.java.Codechef.MonthlyContest.September2020Contest;

import java.util.Arrays;
import java.util.Scanner;

public class AdaMatrix {
    static int res;

    public static void main(String[] args) {

        new AdaMatrix().mainMethod();
    }

    private void mainMethod() {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int res = 0;

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[][] = new int[n][n];
            res = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    arr[j][k] = scanner.nextInt();
            }

            for (int j = n - 1; j > 0; j--) {

                if (arr[j][j] != arr[j][j - 1] + 1) {
                    res++;
                    for (int k = 0; k < j + 1; k++) {
                        for (int l = k + 1; l < j + 1; l++) {
                            if (i != j) {
                                int temp = arr[i][j];
                                arr[i][j] = arr[j][i];
                                arr[j][i] = temp;
                            } } } } }
            System.out.println(res);

        }
    }


//    private static int[][] transpose(int[][] arr, int l) {
//
//        for (int i = 0; i <= l; i++) {
//            for (int j = 0; j <= l; j++) {
//                if (i != j) {
//                    int temp = arr[i][j];
//                    arr[i][j] = arr[j][i];
//                    arr[j][i] = temp;
//                }
//            }
//        }
//
//        return arr;
//    }

    private static boolean isSorted(int[][] arr, int n) {

        boolean isSorted = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != ((i * n) + j + 1))
                    isSorted = false;
            }
        }

        return isSorted;
    }
}
