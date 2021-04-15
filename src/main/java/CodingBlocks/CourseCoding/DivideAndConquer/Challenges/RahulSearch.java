package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Scanner;

public class RahulSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int key = scanner.nextInt();
        int pos = getElementPos(arr, 0, arr.length - 1, key);
        System.out.println(pos);
        scanner.close();
    }

    private static int getElementPos(int[] arr, int s, int e, int key) {

        while (s <= e) {
            int mid = (s + e)/2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[s] <= arr[mid]) {
                if (arr[s] <= key && arr[mid] > key) {
                    e = mid - 1;
                } else
                    s = mid + 1;
            } else {
                if (arr[mid] < key && arr[e] >= key) {
                    s = mid + 1;
                } else
                    e = mid - 1;
            }
        }

        return -1;
    }
}
