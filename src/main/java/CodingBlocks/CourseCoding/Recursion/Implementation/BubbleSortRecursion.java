package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 1};

        arr = bubbleSortRec(arr, 4);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static int[] bubbleSortRec(int[] arr, int k) {
        if (k == 0) return arr;

        for (int i = 1; i < k; i++) {
            if (arr[i] < arr[i-1]) {
                arr[i] += arr[i-1];
                arr[i-1] = arr[i] - arr[i-1];
                arr[i] -= arr[i-1];
            }
        }

        return bubbleSortRec(arr, k-1);
    }
}
