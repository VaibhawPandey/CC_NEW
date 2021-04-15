package main.java.Codechef.MonthlyContest.September2020Contest;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemonSticks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            Arrays.sort(arr);

            int count = 0;
            int max = arr[n-1];
            for (int j = n - 2; j >= 0; j--) {
                if (arr[j] < max) {
                    max = arr[j];
                    count++;
                }
            }

            if (arr[0] != 0)
                count++;

            System.out.println(count);
        }
    }
}
