package main.java.CodingBlocks.CourseCoding.Recursion.SubsetBased;

import java.util.Scanner;

public class StringGenerationAcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generateString(n, "", String.valueOf(n).length() - 1);
        scanner.close();
    }

    private static void generateString(int n, String subRes, int len) {
        if (n == 0) {
            System.out.println(subRes);
            return;
        }

        int temp = (int) Math. pow(10, len);
        if (n / temp != 0) generateString(n % temp, subRes + (char) ('A' + (n / temp) - 1), len - 1);
        temp = (int) Math.pow(10, len - 1);
        if (len > 0 && n / temp <= 26) generateString(n % temp, subRes + (char) ('A' + (n / temp) - 1), len - 2);
    }
}
