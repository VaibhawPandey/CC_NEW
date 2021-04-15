package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class NumberToSpelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        numToSpell(n);
        scanner.close();
    }

    private static void numToSpell(int n) {

        if (n == 0) return;
        int temp = n % 10;

        numToSpell(n/10);
        System.out.print(getWordByNum(temp) + " ");
    }

    private static String getWordByNum(int temp) {
        switch (temp) {
            case 0:  return "Zero";
            case 1:  return "One";
            case 2:  return "Two";
            case 3:  return "Three";
            case 4:  return "Four";
            case 5:  return "Five";
            case 6:  return "Six";
            case 7:  return "Seven";
            case 8:  return "Eight";
            case 9:  return "Nine";
            default: return "";
        }
    }
}
