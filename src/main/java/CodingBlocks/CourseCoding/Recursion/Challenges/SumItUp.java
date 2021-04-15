package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.*;

public class SumItUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        int target = scanner.nextInt();
        List<Integer> positionList = new ArrayList<>();
        Set<String> res = new HashSet<>();
        getRes(arr, 0, arr.length, target, 0, positionList, res);
        scanner.close();
    }

    private static void getRes(int[] arr, int pos, int len, int target, int subTarget, List<Integer> positionList, Set<String> res) {
        if (subTarget >= target || pos == len) {
            if (subTarget == target) {
                String subRes = "";
                for (Integer pstn : positionList)
                    subRes += arr[pstn] + " ";

                subRes = subRes.trim();
              if (!res.contains(subRes)) System.out.println(subRes);
              res.add(subRes);
            }
            return;
        }

        positionList.add(pos);
        getRes(arr, pos + 1, len, target, subTarget + arr[pos], positionList, res);
        positionList.remove(positionList.size() - 1);
        getRes(arr, pos + 1, len, target, subTarget, positionList, res);
    }
}
