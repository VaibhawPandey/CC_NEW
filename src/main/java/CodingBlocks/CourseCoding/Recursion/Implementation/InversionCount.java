package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;

public class InversionCount {
    public static void main(String[] args) {

        int arr[] = {1, 5, 2, 6, 3, 0};
        System.out.println(new InversionCount().inverseSort(arr, 0, arr.length - 1));
    }

    private int inverseSort(int[] arr, int s, int e) {
        if (s >= e) return 0;

        int mid = (s + e)/2;
        int x = inverseSort(arr, s, mid);
        int y = inverseSort(arr, mid + 1, e);
        int inverse_C = inverse(arr, s, mid, e);

        return x + y + inverse_C;
    }

    private int inverse(int[] arr, int s, int mid, int e) {

        int n1 = mid - s + 1, n2 = e - mid;

        int n1Arr[] = new int[n1];
        int n2Arr[] = new int[n2];

        for (int i = 0; i < n1; i++)
            n1Arr[i] = arr[s + i];

        for (int i = 0; i < n2; i++)
            n2Arr[i] = arr[mid + i + 1];

        int i = 0, j = 0, k = s, cnt = 0;
        while (i < n1 && j < n2) {
            if (n1Arr[i] <= n2Arr[j]) {
                arr[k++] = n1Arr[i++];
            } else {
                arr[k++] = n2Arr[j++];
                cnt += mid - (s + i) + 1;
            }
        }

        while (i < n1) {
            arr[k++] = n1Arr[i++];
        }

        while (j < n2) {
            arr[k++] = n2Arr[j++];
        }

        return cnt;
    }
}
