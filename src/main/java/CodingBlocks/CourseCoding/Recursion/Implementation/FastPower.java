package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;

import java.util.Scanner;

public class FastPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(fastPower(a, n));
    }

    private static long fastPower(int a, int n) {
        if (n == 0) return 1;

        if (n % 2 == 0) return (long) Math.pow(fastPower(a, n/2), 2);
        else return (long) (a * Math.pow(fastPower(a, n/2), 2));
    }
}
