package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Arrays;
import java.util.Scanner;

public class PairofRoses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            int m = scanner.nextInt();
            mergeSort(arr, 0, n-1, m);
            int i = 0, j = n-1, resI = -1, resJ = -1;
            while (i < j) {
                int temp = arr[i] + arr[j];
                if (temp == m) {
                    resI = i; resJ = j;
                    i++;j--;
                } else if (temp > m)
                    j--;
                else
                    i++;
            }

//            System.out.println();
//            for (int i = 0; i < n; i++)
//                System.out.print(arr[i] + " ");

            System.out.println("Deepak should buy roses whose prices are " + arr[resI] + " and " + arr[resJ]);
        }
        scanner.close();
    }

    private static void mergeSort(int[] arr, int s, int e, int m) {

        if (s < e) {

            int mid = (s + e)/2;
            mergeSort(arr, s, mid, m);
            mergeSort(arr, mid + 1, e, m);
            merge(arr, s, mid, e);

//            int temp_diff = arr[mid + 1] - arr[mid];
//            if ((arr[mid] + arr[mid + 1] == m) && temp_diff < diff) {
//                diff = temp_diff;
//                pos = mid;
//            }
//
//            if (mid != 0 && (arr[mid] + arr[mid - 1] == m) && (arr[mid] - arr[mid - 1] < diff)) {
//                diff = temp_diff;
//                pos = mid-1;
//            }

        }
    }

    private static void merge(int[] arr, int s, int mid, int e) {

        int temp1[] = Arrays.copyOfRange(arr, s, mid + 1);
        int temp2[] = Arrays.copyOfRange(arr, mid + 1, e + 1);

        int i = 0, j = 0, k = s;
        while (i < temp1.length && j < temp2.length) {
            if (temp1[i] <= temp2[j])
                arr[k++] = temp1[i++];
            else
                arr[k++] = temp2[j++];
        }

        while (i < temp1.length)
            arr[k++] = temp1[i++];

        while (j < temp2.length)
            arr[k++] = temp2[j++];
    }
}
