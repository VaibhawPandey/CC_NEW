package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.Scanner;

public class PlayingWithBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = 0;

            for (int i = a; i <= b; i++) {
                int k = i;
                while (k > 0) {
                    res++;
                    k = k & (k-1);
                }
            }

            System.out.println(res);
        }
    }
}
