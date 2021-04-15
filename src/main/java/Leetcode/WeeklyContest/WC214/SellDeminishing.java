package main.java.Leetcode.WeeklyContest.WC214;

import java.util.Arrays;

public class SellDeminishing {
    public static void main(String[] args) {
        System.out.println(new SellDeminishing().maxProfit(new int[]{4420049,199487178,553327648,737784415,296875712,820580191,644001538,357887155,608015365,232020440,296469719,264703910,980408347}, 14879651));
    }
    public int maxProfit(int[] inventory, int orders) {

        int n = inventory.length;
        int mod = 1000000007;
        if (n == 0)
            return 0;

        Arrays.sort(inventory);
        int index = n - 2, res = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (orders == 0)
                break;

            int numberOfElements = n - i;
            // System.out.println(inventory[i] + "--" + inventory[i-1]);
            // System.out.println((i - 1) >= 0 ? inventory[i - 1] : 0);
            int ordersBetweenEle = (inventory[i] - ((i - 1) >= 0 ? inventory[i - 1] : 0)) * numberOfElements;
            if (ordersBetweenEle <= orders) {
                int num = (int) ((getSum(inventory[i]) - ((i - 1) >= 0 ? getSum(inventory[i - 1]) : 0)) % mod);
                orders -= ordersBetweenEle;
                res = (res + (num*numberOfElements)) % mod;
            } else {

                int numToBeAdded = inventory[i];
                int o1 = orders/numberOfElements;
                int rem = orders % numberOfElements;
                res = (int) ((res + ((getSum(numToBeAdded) - getSum(numToBeAdded-o1)) * numberOfElements) % mod) % mod);
                numToBeAdded -= o1;
//                while (orders >= numberOfElements) {
//                    orders -= numberOfElements;
//                    res = (int) ((res + ((long) numToBeAdded * (long) numberOfElements) % mod) % mod);
//                    numToBeAdded--;
//                }

                res = (int) ((res + (((long) numToBeAdded * (long) rem) % mod)) % mod);
                orders = 0;
            }
        }

        return res;
    }

    private long getSum(int n) {
        // long num =
        return (((long) n * (long) (n + 1)) / 2) % 1000000007;
    }
}
