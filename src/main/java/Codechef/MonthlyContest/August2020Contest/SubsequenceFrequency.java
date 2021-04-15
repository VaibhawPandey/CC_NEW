package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsequenceFrequency {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            List<Integer> subArray = new ArrayList<>();
            int subArrayCount[] = new int[n + 1];
            resA = new int[n + 1];
            int minVal = Integer.MAX_VALUE, maxCount = Integer.MIN_VALUE;
            new SubsequenceFrequency().allSubsequence(arr, 0, subArrayCount, minVal, maxCount);

            for (int j = 1; j < resA.length; j++)
                System.out.print(resA[j] +" ");
        }
    }

    static int resA[];
    private void allSubsequence(int[] arr, int index, int[] subArrayCount, int minVal, int maxCount) {

        if (index == arr.length) {

            if (minVal != Integer.MAX_VALUE)
                resA[minVal] = (resA[minVal] + 1) % 1000000007;

        } else {

            allSubsequence(arr, index + 1, subArrayCount, minVal, maxCount);

            subArrayCount[arr[index]]++;

            if (subArrayCount[arr[index]] == maxCount)
                minVal = Math.min(minVal, arr[index]);
            else
            if (subArrayCount[arr[index]] > maxCount) {
                maxCount = subArrayCount[arr[index]];
                minVal = arr[index];
            }

            allSubsequence(arr, index + 1, subArrayCount, minVal, maxCount);

            subArrayCount[arr[index]]--;

        }
    }


//    private void allSubsequence(int[] arr, int index, List<Integer> subArray, int[] subArrayCount, int minVal, int maxCount) {
//
//        if (index == arr.length) {
//
////            int resArray[] = new int[arr.length + 1];
////            int minVal = Integer.MAX_VALUE, maxCount = Integer.MIN_VALUE;
////            if (subArray.size() != 0) {
////                for (Integer val : subArray) {
////                    resArray[val]++;
////
////                    if (resArray[val] == maxCount) {
////                        minVal = Math.min(val, minVal);
////                        continue;
////                    }
////                    if (resArray[val] > maxCount) {
////
////                        maxCount = resArray[val];
////                        minVal = val;
////                    }
////                }
//
//                resA[minVal] = (resA[minVal] + 1) % 1000000007;
//            }
//        } else {
//
//            allSubsequence(arr, index + 1, subArray, subArrayCount, minVal, maxCount);
//
//            // TODO
//            List<Integer> arrList = new ArrayList<>(subArray);
//            arrList.add(arr[index]);
//
//
//            subArrayCount[arr[index]]++;
//
//
//            allSubsequence(arr, index + 1, arrList, subArrayCount, minVal, maxCount);
//        }
//    }


}
