package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            int s = 0, e = n - 1;
            long count = mergeSort(arr, s, e);
//            for (int i = 0; i < arr.length; i++)
//                System.out.print(arr[i] + " ");
            System.out.println(count);
        }
        scanner.close();
    }

    private static long mergeSort(int[] arr, int s, int e) {
        long count = 0;
        if (s < e) {
            int mid = (s + e)/2;
            count += mergeSort(arr, s, mid);
            count += mergeSort(arr, mid + 1, e);
            count += merge(arr, s, mid, e);
        }

        return count;
    }

    private static long merge(int[] arr, int s, int mid, int e) {
        long count = 0;
        int temp1[] = Arrays.copyOfRange(arr, s, mid + 1),
                temp2[] = Arrays.copyOfRange(arr, mid + 1, e + 1);

        int k = s, i = 0, j = 0;
        while (i < temp1.length && j < temp2.length) {
            if (temp1[i] <= temp2[j]) {
                arr[k++] = temp1[i++];
            } else {
                arr[k++] = temp2[j++];
                count += (mid + 1) - (s + i);
            }
        }

        while (i < temp1.length)
            arr[k++] = temp1[i++];
        while (j < temp2.length)
            arr[k++] = temp2[j++];

        return count;
    }

//    private static int getCount(int[] arr, int s, int e) {
//
//        if (s >= e) return 0;
//        int count = 0, mid = (s + e)/2;
//
//        count += getCount(arr, s, mid);
//        count += getCount(arr, mid + 1, e);
//        count += getCnt(arr, s, mid, e);
//
//        return count;
//    }
//
//    private static int getCnt(int[] arr, int s, int mid, int e) {
//        int count = 0, i = s, j = mid + 1;
//
//        while (i <= mid && j <= e) {
//            if (arr[i] > arr[j]) {
//                count++;
//                i++;
//            } else j++;
//        }
//
//        return count;
//    }
}
