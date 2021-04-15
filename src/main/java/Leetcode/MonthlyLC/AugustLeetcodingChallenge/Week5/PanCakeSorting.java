package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PanCakeSorting {

    public static void main(String[] args) {
        System.out.println(new PanCakeSorting().pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public List<Integer> pancakeSort(int[] A) {

        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {

            int maxElementPos = getMaxElementPosition(i, A);

            if (maxElementPos != i) {
                res.add(maxElementPos + 1);
                A = reverseArray(A, maxElementPos);
                res.add(i + 1);
                A = reverseArray(A, i);
            }
        }

        return res;
    }

    private int[] reverseArray(int[] a, int maxElementPos) {
        int start = 0;

        while (start < maxElementPos) {
            int temp = a[start];
            a[start] = a[maxElementPos];
            a[maxElementPos] = temp;
            maxElementPos--;
            start++;
        }

        return a;
    }

    private int getMaxElementPosition(int pos, int[] a) {

        int maxElementPos = -1, maxElement = Integer.MIN_VALUE;
        for (int i = 0; i <= pos; i++) {
            if (maxElement < a[i]) {
                maxElement = a[i];
                maxElementPos = i;
            }
        }

        return maxElementPos;
    }
}
