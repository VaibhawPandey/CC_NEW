package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        for (Integer out : new PascalTriangle().getRow(3)) {
            System.out.print(out +" ");
        }
    }

    // Alternative
    public List<Integer> getRow(int rowIndex) {

        Integer res[] = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res[j] += res[j - 1];
            }
        }

        return Arrays.asList(res);
    }

//    public List<Integer> getRow(int rowIndex) {
//
//        Integer digit[] = new Integer[rowIndex + 1];
//        Integer lastDigit[] = new Integer[rowIndex+1];
//
//        for (int i = 0; i <= rowIndex; i++) {
//            for (int j = 0; j <= i; j++) {
//
//                if (j == 0 || j == i)
//                    digit[j] = 1;
//                else
//                    digit[j] = lastDigit[j-1] + lastDigit[j];
//            }
//            System.arraycopy(digit, 0, lastDigit, 0, i + 1);
//        }
//
//        return new ArrayList<>(Arrays.asList(digit));
//    }
}
