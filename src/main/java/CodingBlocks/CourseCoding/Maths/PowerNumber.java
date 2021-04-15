package main.java.CodingBlocks.CourseCoding.Maths;

import java.util.Scanner;

public class PowerNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if (a == 0) {
            System.out.println(0);
            return;
        }
        int b = scanner.nextInt();
        System.out.println(numberPow(a, b));
    }

    private static int numberPow(int a, int b) {

        if (b == 0) return 1;

        if (b % 2 == 0) return (int) Math.pow(numberPow(a, b/2), 2);
        else return a * (int) Math.pow(numberPow(a, b/2), 2);
    }
}
