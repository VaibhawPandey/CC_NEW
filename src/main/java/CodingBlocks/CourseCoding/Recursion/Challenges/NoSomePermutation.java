package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.*;

public class NoSomePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = scanner.nextInt();
        Arrays.sort(input);
        List<String> output = new LinkedList<>();
        getRes(input, 0, input.length, output, "");
        for (String str: output)
            System.out.println(str);
        scanner.close();
    }

    private static void getRes(int[] input, int pos, int len, List<String> output, String subRes) {
        if (pos == len) {
            output.add(subRes.trim());
            return;
        }

        for (int i = pos; i < input.length; i++) {
            int p = input[i], q = input[pos];
            if (i == pos || p != q) {
                swapArr(input, i, pos);
                getRes(input, pos + 1, len, output, subRes + " " +  String.valueOf(input[pos]));
                swapArr(input, i, pos);
            }
        }
    }

    private static void swapArr(int[] input, int i, int pos) {
        int temp = input[i];
        input[i] = input[pos];
        input[pos] = temp;
    }

    private static boolean sameDigit(String n1, String n2) {

        int len1 = n1.length(), len2 = n2.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (n1.charAt(i) != n2.charAt(j))
                return false;
            i++;
            j++;
        }

        while (i < len1) {
            if (n1.charAt(i - 1) != n1.charAt(i))
                return false;
            i++;
        }

        while (j < len2) {
            if (n2.charAt(j) != n2.charAt(j - 1))
                return false;
            j++;
        }

        return true;
    }
}
