package main.java.Vaibhaw_GH.src;

import main.java.Vaibhaw_GH.src.Combinations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseEngg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int mapArr[][] = new int[101][];
        for (int i = 2; i <= 100; i++) {
            mapArr[i] = createArr(i);
        }

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int val = scanner.nextInt();
            int arr[] = mapArr[n];

            if (val < n-1) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                continue;
            }
            boolean isResultFound = permute(arr, 0, n, val);
            if (!isResultFound) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            } else {
                String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static int[] createArr(int i) {
        int arr[] = new int[i];
        for (int j = 1; j <= i; j++)
            arr[j-1] = j;
        return arr;
    }

    public static boolean permute(int arr[], int k, int n, int val){
        for(int i = k; i < n; i++){
            swapArrEle(arr, i, k);
            boolean isFound = permute(arr, k+1, n, val);
            if (isFound) {
                return true;
            }
            swapArrEle(arr, k, i);
        }
        if (k == n -1){
            // integers.add(new ArrayList<>(arr));
            int updatedArr[] = Arrays.copyOf(arr, n);
            int pos = 0, res = 0;
            while (pos < n-1) {
                int p = pos, lastNumber = updatedArr[pos];
                for (int j = pos + 1; j < n; j++) {
                    if (updatedArr[j] < lastNumber) {
                        p = j;
                        lastNumber = updatedArr[j];
                    }
                }
                if (pos != p) swapArr(updatedArr, pos, p);
                res += p - pos + 1;
                pos++;
            }

            if (res == val)
                return true;
        }

        return false;
    }

    private static void swapArrEle(int[] arr, int k, int pos) {
        int temp = arr[k];
        arr[k] = arr[pos];
        arr[pos] = temp;
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
