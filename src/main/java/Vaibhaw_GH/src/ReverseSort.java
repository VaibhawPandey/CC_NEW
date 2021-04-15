package main.java.Vaibhaw_GH.src;

import main.java.Vaibhaw_GH.src.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> num = new ArrayList<>();
        int n1 = scanner.nextInt();
        for (int i = 1; i <= n1; i++)
            num.add(i);
        new Combinations().permute(num, 0, list);
        long max = Integer.MIN_VALUE;
        int t = list.size();
        for (int i = 0; i < t; i++) {
            int pos = 0, n = list.get(i).size();
            System.out.println(list.get(i));
            long res = 0;
            int arr[] = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = list.get(i).get(j);

            while (pos < n-1) {
                int k = pos, lastNumber = arr[pos];
                for (int j = pos + 1; j < n; j++) {
                    if (arr[j] < lastNumber) {
                        k = j;
                        lastNumber = arr[j];
                    }
                }
                if (pos != k) swapArr(arr, pos, k);
                res += k - pos + 1;
                pos++;
            }

            max = Math.max(max, res);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
        System.out.println("Max:-" + max);
        scanner.close();
    }

    private static void swapArr(int[] arr, int pos, int k) {
        while (pos < k) {
            int temp = arr[k];
            arr[k] = arr[pos];
            arr[pos] = temp;
            pos++;
            k--;
        }

    }
}
