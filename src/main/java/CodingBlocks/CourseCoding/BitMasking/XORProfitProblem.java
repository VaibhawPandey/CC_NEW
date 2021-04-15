package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.Scanner;

public class XORProfitProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int max = 0;
        for (int i = a; i < b; i++) {
            max = Math.max(max, (i ^ (i + 1)));
        }
        System.out.println(max);
    }
}
