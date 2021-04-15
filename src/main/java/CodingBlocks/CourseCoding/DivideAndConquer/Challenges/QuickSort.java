package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    static Random random = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        quickSort(arr, 0, n-1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        scanner.close();
    }

    private static void quickSort(int[] arr, int s, int e) {

        if (s < e) {

            int mid = partition(arr, s, e);
            quickSort(arr, s, mid-1);
            quickSort(arr, mid + 1, e);

        }
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = getPivot(arr, s, e);

        int k = s - 1;
        for (int i = s; i < e; i++) {
            if (arr[i] < pivot) {
                k++;
                swapArr(arr, k, i);
            }
        }

        swapArr(arr, k + 1, e);
        return k + 1;
    }

    private static int getPivot(int[] arr, int s, int e) {

        int pos = random.nextInt(e-s) + s;
        swapArr(arr, pos, e);

        return arr[e];
    }

    private static void swapArr(int[] arr, int pos, int e) {
        int temp = arr[pos];
        arr[pos] = arr[e];
        arr[e] = temp;
    }
}
