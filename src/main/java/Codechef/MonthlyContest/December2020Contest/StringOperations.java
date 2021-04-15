package main.java.Codechef.MonthlyContest.December2020Contest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class StringOperations {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter printWriter = new PrintWriter(System.out);

        int t = fastReader.nextInt();

        while (t-- > 0) {

            String s = fastReader.next();
            int n = s.length();
            char sChar[] = new char[n];
            int noOf1[] = new int[n + 1];
            HashSet<String> strList[] = new HashSet[n];

            for (int i = 1; i <= n; i++) {
                noOf1[i] = sChar[i - 1] == '1' ? noOf1[i - 1] + 1 : noOf1[i - 1];
                strList[i-1] = new HashSet<>();
            }


            // Arrays.fill(strList, new HashSet<String>());

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++)
                    strList[j - i].add(s.substring(i, j + 1));
            }

            int res = 0;

            for (int i = 0; i < strList.length; i++) {
                if (i == 0 || i == 1)
                    res += strList[i].size();
                else {
                    res += comparedListSize(strList[i]);
                }
            }
            printWriter.println(res);
        }
        printWriter.flush();
    }

    private static int comparedListSize(HashSet<String> list) {

        if (list.size() <= 1)
            return list.size();

        ArrayList<String> arrayList = new ArrayList<>(list);
        boolean removed[] = new boolean[list.size()];
        int removedCount = 0;

        for (int i = 0; i < arrayList.size() && !removed[i]; i++) {
            char a[] = arrayList.get(i).toCharArray();
            for (int j = i + 1; j < arrayList.size() && !removed[j]; j++) {

                int countof1Left = 0, countOf1Right = 0;
                char b[] = arrayList.get(j).toCharArray();
                boolean isEqual = false;
                int left = 0;
                for (int k = 0; k < arrayList.get(i).length(); k++) {
                    if (a[k] == '1') countof1Left++;
                    if (b[k] == '1') countOf1Right++;

                    if (countof1Left != 0 && countof1Left % 2 == 0 && countof1Left == countOf1Right) {
                        isEqual = true;
                        int right = k;
                        while (left <= k) {
                            if (a[left] != b[right]) {
                                isEqual = false;
                                break;
                            }
                            left++;
                            right--;
                        }

                        if (isEqual) {
                            left = k + 1;
                            countof1Left = 0;
                            countOf1Right = 0;
                        }
                    }
                }

                if (countof1Left != countOf1Right)
                    isEqual = false;

                if (isEqual) {
                    removed[j] = true;
                    removedCount++;
                }
            }
        }

        return arrayList.size() - removedCount;
    }
}
