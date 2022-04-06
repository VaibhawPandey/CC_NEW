package main.java.Leetcode.MonthlyLC.LC2022.MarchLC;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 1}));
    }
    public int maxArea(int[] height) {

        int res = Integer.MIN_VALUE, maxPosition = 1, maxHeight = height[0];
        for (int i = 2; i <= height.length; i++) {
            if (height[i-1] > maxHeight) {
                maxHeight = height[i-1];
                maxPosition = i;
                res = Math.max(res, maxHeight * i);
            } else res = Math.max(res, height[i-1] * (i - maxPosition));
        }

        return res;
    }
}
