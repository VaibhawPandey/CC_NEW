package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.*;

public class TrickyPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char str[] = scanner.next().toCharArray();
        Set<String> strList = new HashSet<>();
        getRecurString(str, 0, str.length, strList);
        System.out.println(strList);
        List<String> resList = new ArrayList<>(strList);
        Collections.sort(resList);
        for (String res: resList) {
            System.out.println(res);
        }
        scanner.close();
    }

    private static void getRecurString(char str[], int pos, int len, Set<String> strList) {
        if (pos == len) {
            strList.add(String.valueOf(str));
            return;
        }

        for (int i = pos; i < str.length; i++) {
           swapStr(str, pos, i);
           getRecurString(str, pos + 1, len, strList);
           swapStr(str, pos, i);
        }
    }

    private static void swapStr(char[] str, int pos, int i) {
        char c = str[pos];
        str[pos] = str[i];
        str[i] = c;
    }
}
