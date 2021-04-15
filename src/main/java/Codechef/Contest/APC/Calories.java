package main.java.Codechef.Contest.APC;

import java.util.*;

public class Calories {
    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairList.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.key > o2.key ? -1: 1;
            }
        });

        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += pairList.get(i).value;
            res = Math.max(res, sum - pairList.get(i).key);
        }

        System.out.println(res);
    }
}
