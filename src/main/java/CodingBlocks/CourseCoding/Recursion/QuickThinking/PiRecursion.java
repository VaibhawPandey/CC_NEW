package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class PiRecursion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char a[] = new char[1000000];
        a = scanner.next().toCharArray();
        int len = 0;
        while (a[len] != '\0')
            len++;

        recursePI(a, 0, len);
        int pos = 0;
        while (a[pos] != '\0')
            System.out.print(a[pos]);
        scanner.close();
    }

    private static void recursePI(char[] a, int pos, int len) {
        if (a[pos] == '\0' || a[pos+1] == '\0')
            return;

        if (a[pos] == 'p' && a[pos+1] == 'i') {

            int k = len + 2;
            while (k >= pos+2) {
                a[k] = a[k-2];
                k--;
            }
            a[pos] = '3'; a[pos+1] = '.';
            a[pos+2] = '1'; a[pos+3] = '4';
            recursePI(a, pos+2, len+2);
        } else {
            recursePI(a, pos+1, len);
        }
    }


}
