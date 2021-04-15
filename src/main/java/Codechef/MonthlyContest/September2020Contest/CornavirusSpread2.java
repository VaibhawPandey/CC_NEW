package main.java.Codechef.MonthlyContest.September2020Contest;

import java.util.*;

public class CornavirusSpread2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int v[] = new int[n];

            int maxCount = 1, minCount = 1;

            for (int j = 0; j < n; j++)
                v[j] = scanner.nextInt();

            boolean mVisited[] = new boolean[n];

            for (int j = 0; j < n; j++) {

                boolean visited[] = new boolean[n];
                mVisited = new boolean[n];
                Queue<Integer> queue = new ArrayDeque<>();
                // visited[j] = true;
                int count = 1;
                queue.add(j);

                while (!queue.isEmpty()) {
                    int pos = queue.poll();
                    if (!visited[pos]) {
                        visited[pos] = true;

                        for (int k = pos + 1; k < n; k++) {
                            if (!queue.contains(k) && !visited[k] && v[pos] > v[k]) {
                                int diff = v[pos] - v[k];
                                if ((k - pos) % diff == 0) {
                                    queue.add(k);
                                    count++;
                                }
                            }
                        }
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    mVisited = visited;
                }
            }

            minCount = maxCount == n ? maxCount : 1;
            if (n - maxCount == 2) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < mVisited.length; j++) {
                    if (!mVisited[j])
                        list.add(j);
                }
                if ( v[list.get(0)] > v[list.get(1)]) {
                    int diff = v[list.get(0)] - v[list.get(1)];
                    if ((list.get(1) - list.get(0)) % diff == 0)
                        minCount++;
                }
            }

            // System.out.println(minCount +" " + maxCount);

//            int count = 1;
//            HashSet<Integer> hashSet = new HashSet<>();
//            HashSet<Integer> mainMaxSet = new HashSet<>();
//
//            for (int j = 0; j < n; j++) {
//                if (mainMaxSet.contains(j)) {
//                    count = mainMaxSet.size();
//                } else {
//                    hashSet.clear();
//                    count = 1;
//                }
//                    for (int k = j + 1; k < n; k++) {
//                        if (v[j] > v[k]) {
//                            int diff = v[j] - v[k];
//                            if ((k - j) % diff == 0) {
//                                count++;
//                                hashSet.add(k);
//                                hashSet.add(j);
//                            }
//                        }
//                    }
//
//                    if (count > maxCount) {
//                        maxCount = count;
//                        if (!mainMaxSet.contains(j)) mainMaxSet = new HashSet<>();
//                        mainMaxSet.addAll(hashSet);
//                    }
//
//                    if (!mainMaxSet.contains(j) && count > minCount) {
//                        minCount = hashSet.size();
//                    }
//            }
//
//            if (maxCount == n) minCount = 0;

            System.out.println(minCount + " " + maxCount);
        }
    }
}
