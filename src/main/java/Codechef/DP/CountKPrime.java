package main.java.Codechef.DP;

import java.util.Scanner;

public class CountKPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();

            int primeCount[] = new int[b + 1];
            for (int p = 2; p <= b; p++) {
                if (primeCount[p] == 0) {
                    for (int j = p; j <= b; j = j + p)
                            primeCount[j]++;
                }
            }

            int res = 0;
            for (int j = a; j <= b; j++) {
                if (primeCount[j] == k)
                    res++;
            }

            System.out.println(res);

        }
    }
}
