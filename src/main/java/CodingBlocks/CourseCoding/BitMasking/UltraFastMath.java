package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UltraFastMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String a = scanner.next();
            String b = scanner.next();
            int len1 = a.length(), len2 = b.length();
            int i = 0;

            while (len1 > 0 || len2 > 0) {
                int k = (len1 > 0 ? (a.charAt(i) - '0') : 0) ^ (len2 > 0 ? (b.charAt(i) - '0') : 0);
                i++;
                len1--; len2--;
            }
            System.out.println();
        }
    }
}
