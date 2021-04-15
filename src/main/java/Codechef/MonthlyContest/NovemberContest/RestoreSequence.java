package main.java.Codechef.MonthlyContest.NovemberContest;

import main.java.Codechef.MonthlyContest.December2020Contest.FastReader;

import java.util.*;

public class RestoreSequence {
    public static void main(String[] args) {

        int l = 4000001;
        boolean arr[] = new boolean[l];
        List<Integer> primeNumberList = new ArrayList<>();

        Arrays.fill(arr, true);

        for (int i = 2; i * i < l; i++) {
            if (arr[i] == true) {
                primeNumberList.add(i);
                for (int j = i*i; j < l; j+=i)
                    arr[j] = false;
            }
        }



        FastReader fastReader = new FastReader();
        int t = fastReader.nextInt();

        while (t-- > 0) {

            int n = fastReader.nextInt();
            int arrList[] = new int[n];

            Map<Integer, List<Integer>> map = new HashMap<>();
            int index = 0;

            for (int i = 0; i < n; i++) {
                arrList[i] = fastReader.nextInt();
                if (map.containsKey(arrList[i])) {
                    int temp = arrList[i];
                    arrList[i] = map.get(arrList[i]).get(1);
                    map.get(temp).add(1, arrList[i] * map.get(temp).get(0));
                } else {
                    List<Integer> arrL = new ArrayList<>();
                    int temp = primeNumberList.get(index);
                    arrL.add(temp);
                    arrL.add(temp * temp);
                    map.put(arrList[i], arrL);
                    arrList[i] = temp;
                    index++;
                }

                System.out.print(arrList[i] +" ");
                System.out.println();
            }

        }
    }
}
