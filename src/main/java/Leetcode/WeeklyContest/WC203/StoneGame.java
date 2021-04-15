package main.java.Leetcode.WeeklyContest.WC203;

public class StoneGame {

    public static void main(String[] args) {
        System.out.println(new StoneGame().stoneGameV(new int[] {68,75,25,50,34,29,77,1,2,69}));
    }

    int res;
    public int stoneGameV(int[] stoneValue) {

        return getResult(0, stoneValue.length - 1, stoneValue);
    }

    private int getResult(int start, int end, int[] stoneValue) {

        int ans = 0;
        int leftSum = 0, rightSum = 0;

        for (int i = start; i <= end; i++)
            rightSum += stoneValue[i];

        for (int i = start; i < end; i++) {

            leftSum += stoneValue[i];
            rightSum -= stoneValue[i];

            if (leftSum == rightSum) ans = Math.max(ans, leftSum + Math.max(getResult(start, i, stoneValue), getResult(i+1, end, stoneValue)));
            if (leftSum > rightSum) ans = Math.max(ans, rightSum + getResult(i+1, end, stoneValue));
            if (leftSum < rightSum) ans = Math.max(ans, leftSum + getResult(start, i, stoneValue));
        }

        return ans;
    }
}
