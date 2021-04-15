package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.Scanner;

public class IncredibleHulk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt(), num = 1;

            while (num < n) {
                num = num << 1;
            }

            num = num > n ? num >> 1: num;

            System.out.println(1 + (n - num));
        }
    }
}
