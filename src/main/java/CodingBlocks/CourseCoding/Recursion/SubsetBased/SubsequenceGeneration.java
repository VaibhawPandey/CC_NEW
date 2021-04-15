package main.java.CodingBlocks.CourseCoding.Recursion.SubsetBased;

import java.util.Scanner;

public class SubsequenceGeneration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        subRec(str, 0, str.length(), "");
        scanner.close();
    }

    private static void subRec(String str, int index, int length, String subRes) {
        if (index == length) {
            System.out.println(subRes);
            return;
        }

        subRec(str, index + 1, length, subRes + str.charAt(index));
        subRec(str, index + 1, length, subRes);
    }
}
