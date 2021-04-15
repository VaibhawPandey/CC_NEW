package main.java.CodingBlocks.CourseCoding.Recursion.BackTracking;

import java.util.Scanner;

public class CPPPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char sArr[] = scanner.next().toCharArray();

        allPermutation(sArr, 0, sArr.length);
        scanner.close();
    }

    private static void allPermutation(char[] sArr, int index, int len) {
        if (index == len) {
            System.out.println(sArr);
            return;
         }

        for (int i = index; i < len; i++) {
            swapArr(sArr, index, i);
            allPermutation(sArr, index + 1, len);
            swapArr(sArr, i, index);
        }
    }

    private static void swapArr(char[] sArr, int index, int i) {
        char c = sArr[index];
        sArr[index] = sArr[i];
        sArr[i] = c;
    }
}
