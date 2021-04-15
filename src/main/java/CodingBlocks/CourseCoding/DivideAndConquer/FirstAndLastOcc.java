package main.java.CodingBlocks.CourseCoding.DivideAndConquer;

import java.util.Scanner;

public class FirstAndLastOcc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {1, 2, 2, 4, 4, 4, 4, 8, 8, 12};
        int key = scanner.nextInt();
        System.out.println("First :- " + getFirstIndex(arr, key));
        System.out.println("Last :- " + getLastIndex(arr, key));
        scanner.close();
    }

    private static int getLastIndex(int[] arr, int key) {
        int resIndex = -1, s = 0, e = arr.length - 1;

        while (s < e) {
            int mid = (s + e)/2;

            if (arr[mid] == key && arr[mid+1] > key) {
                s = mid;
                break;
            } else if (arr[mid] > key) {
                e = mid;
            } else if (arr[mid] == key || arr[mid] < key)
                s = mid + 1;
        }

        if ((s == arr.length - 1 || s == 0)&& arr[s] != key)
            return -1;

        return s;
    }

    private static int getFirstIndex(int[] arr, int key) {
        int resIndex = -1, s = 0, e = arr.length - 1;

        while (s < e) {
            int mid = (s + e)/2;

            if (arr[mid] == key && arr[mid-1] < key) {
                s = mid;
                break;
            } else if (arr[mid] == key || arr[mid] > key) {
                e = mid;
            } else if (arr[mid] < key)
                s = mid + 1;
        }

        if ((s == 0 || s == arr.length - 1) && arr[s] != key)
            return -1;

        return s;
    }

}
