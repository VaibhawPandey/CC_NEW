package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;


public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {2, 7, 8, 6, 1, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = partition(arr, l, r);
        quickSort(arr, l, mid-1);
        quickSort(arr, mid+1, r);
    }

    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];

        int i = l - 1;
        while (l <= r) {
            if (arr[l] < pivot) {
                i++;
                swapArr(arr, i, l);
            }
            l++;
        }

        swapArr(arr, i+1, r);
        return i + 1;
    }

    private static void swapArr(int[] arr, int i, int l) {
        int temp = arr[i];
        arr[i] = arr[l];
        arr[l] = temp;
    }
}
