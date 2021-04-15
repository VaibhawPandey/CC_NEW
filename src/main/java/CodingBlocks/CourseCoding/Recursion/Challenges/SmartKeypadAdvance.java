package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SmartKeypadAdvance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input[] = scanner.next().toCharArray();
        String table[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String searchIn [] = {
                "prateek", "sneha", "deepak", "arnav", "shikha", "palak",
                "utkarsh", "divyam", "vidhi", "sparsh", "akku"
        };
        Set<String> strList = new HashSet<>();
        getKeyList(input, 0, input.length, table, "", strList);
        boolean isAlreadyPrinted[] = new boolean[searchIn.length];
        for (String str: strList) {
            for (int i = 0; i < searchIn.length; i++) {
                if (!isAlreadyPrinted[i] && searchIn[i].contains(str)) {
                    System.out.println(searchIn[i]);
                    isAlreadyPrinted[i] = true;
                }
            }
        }
        scanner.close();
    }

    private static void getKeyList(char[] input, int i, int len, String[] table, String subRes, Set<String> strList) {
        if (i == len) {
            strList.add(subRes);
            return;
        }

        int in = input[i] - '0';
        if (in <= 1) {
            getKeyList(input, i + 1, len, table, subRes, strList);
            return;
        }

        char posChar[] = table[in].toCharArray();
        for (int j = 0; j < posChar.length; j++) {
            getKeyList(input, i + 1, len, table, subRes + posChar[j], strList);
        }

    }
}
