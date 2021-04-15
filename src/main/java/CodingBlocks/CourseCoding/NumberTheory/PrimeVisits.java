package main.java.CodingBlocks.CourseCoding.NumberTheory;

import java.util.Scanner;

public class PrimeVisits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean isNotPrime[] = new boolean[1000001];
        isNotPrime[1] = true;
        for (long i = 2; i <= 1000000; i++) {
            if (!isNotPrime[(int) i]) {
                for (long j = i * i; (j + i) <= 1000000; j = j + i) {
                    isNotPrime[(int) j] = true;
                }
            }
        }

        int sum[] = new int[1000001];
        for (int i = 1; i < 1000001; i++)
            sum[i] = sum[i-1] + (isNotPrime[i] ? 0: 1);


        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(sum[b] - (a == 0 ? sum[0]: sum[a-1]));
        }
    }
}
