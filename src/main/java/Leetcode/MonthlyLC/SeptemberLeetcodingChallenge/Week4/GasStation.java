package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week4;

public class GasStation {
    public static void main(String[] args) {
        new GasStation().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumleft = 0, total = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int gasSum = gas[i] - cost[i];

            if (sumleft >= 0) {
                sumleft += gasSum;
            } else {
                sumleft += gasSum;
                start = i;
            }

            total += gasSum;
        }

        if (total >= 0) return start;
        else return -1;
    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//        int gasolinSum = 0;
//        for (int i = 0; i < gas.length; i++) {
//            gasolinSum += gas[i] - cost[i];
//            if (gasolinSum > 0) {
//                int index = Integer.MAX_VALUE;
//                for (int j = i + 1; j < (gas.length + i); j++) {
//                    index = j % gas.length;
//                    gasolinSum += gas[index] - cost[index];
//
//                    if (gasolinSum < 0)
//                        break;
//                }
//
//                if (index == i && gasolinSum >= 0) {
//                    return i;
//                }
//            }
//            gasolinSum = 0;
//        }
//
//        return -1;
//    }
}
