package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Scanner;

public class LinearChess {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int arr[] = new int[n];
            int res = Integer.MAX_VALUE;
            int out = -1;
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();

                if (k >= arr[j] && k % arr[j] == 0 && (k / arr[j]) < res) {
                    res = k / arr[j];
                    out = arr[j];
                }
            }

            System.out.println(out);
        }
    }
}
