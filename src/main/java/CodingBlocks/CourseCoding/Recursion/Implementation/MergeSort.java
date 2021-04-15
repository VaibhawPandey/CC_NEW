package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        new MergeSort().mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;

        int mid = (s + e)/2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int mid, int e) {

        int n1 = mid - s + 1;
        int n2 = e - mid;

        int n1Arr[] = new int[n1], n2Arr[] = new int[n2];
        for (int i = 0; i < n1; i++)
            n1Arr[i] = arr[s + i];

        for (int i = 0; i < n2; i++)
           n2Arr[i] = arr[mid + i + 1];

        int k = s, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (n1Arr[i] < n2Arr[j]) {
                arr[k] = n1Arr[i];
                i++;
            } else {
                arr[k] = n2Arr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k++] = n1Arr[i++];
        }

        while (j < n2) {
            arr[k++] = n2Arr[j++];
        }
    }
}
