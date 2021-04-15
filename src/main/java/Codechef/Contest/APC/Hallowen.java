package main.java.Codechef.Contest.APC;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Hallowen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - K; i++) {
            min = Math.min(min, arr[i + K - 1] - arr[i]);
        }

        System.out.println(min);

    }
}
