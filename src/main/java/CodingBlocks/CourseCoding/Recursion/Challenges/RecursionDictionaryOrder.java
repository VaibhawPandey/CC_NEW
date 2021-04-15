package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.*;
import java.util.stream.Collectors;

public class RecursionDictionaryOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char str[] = scanner.next().toCharArray();
        int n = str.length;
//        char repStr[] = str.clone();
//        Arrays.sort(repStr);
//        int n = str.length, pos = -1;
//        for (int i = 0; i < n; i++)
//            if (str[0] == repStr[i]) {
//                pos = i;
//                break;
//            }
//        char c = str[0];
//        int n = str.length, pos = 0;
//        Arrays.sort(str);
//        for (int i = 1; i < n; i++) {
//            if (str[i] == c) {
//                str[i] = str[i-1];
//                pos = i;
//                break;
//            }
//            str[i] = str[i-1];
//        }
//        str[0] = c;
        List<String> resList = new LinkedList<>();
        getResult(str, 0, n, resList);
        Collections.sort(resList);
        for (String res: resList)
            if (res.compareTo(String.valueOf(str)) > 0)
            System.out.println(res);

        scanner.close();
    }

    private static void getResult(char[] str, int pos, int n, List<String> res) {
        if (pos == n) {
            res.add(String.valueOf(str));
            return;
        }

        for (int i = pos; i < n; i++) {
            swapStr(str, i, pos);
            getResult(str, pos + 1, n, res);
            swapStr(str, i, pos);
        }

    }

    private static void swapStr(char[] str, int i, int j) {
       char temp = str[i];
       str[i] = str[j];
       str[j] = temp;
    }
}
