package main.java.CodingBlocks.CourseCoding.Maths;

import java.util.Scanner;

public class BostonNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();

        int sqrtN = (int) Math.sqrt(n);
        boolean notPrime[] = new boolean[sqrtN + 1];

        for (int i = 2; i <= sqrtN; i++) {
            if (!notPrime[i]) {
                for (int j = (i * i); j <= sqrtN; j = j + i)
                    notPrime[j] = true;
            }
        }

        long k = n, sum = 0, sumofFactors = 0;
        while (k > 0) {
            sum += k % 10;
            k /= 10;
        }

        for (int i = 2; i <= sqrtN && n > 0; i++) {
            if (!notPrime[i]) {
                while (n % i == 0) {
                    n /= i;
                    sumofFactors += i;
                }
            }
        }

        if (sum == sumofFactors)
            System.out.println(1);
        else
            System.out.println(0);

    }
}
