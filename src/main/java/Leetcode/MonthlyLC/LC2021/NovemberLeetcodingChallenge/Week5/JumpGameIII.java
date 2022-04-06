package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week5;

public class JumpGameIII {
    public static void main(String[] args) {
        System.out.println(new JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }
    boolean visited[];
    public boolean canReach(int[] arr, int start) {

        visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }

    private boolean solve(int[] arr, int start, boolean visited[]) {

        if (arr[start] == 0 && visited[start])
            return true;

        if (visited[start])
            return false;

        boolean res = false;
        visited[start] = true;
        if (check(start + arr[start], arr.length))  {
            res = solve(arr, start + arr[start], visited);
            visited[start] = false;
        }
        if (!res) {
            if (check(start - arr[start], arr.length)) {
                res = solve(arr, start - arr[start], visited);
                visited[start] = false;
            }
        }

        return res;
    }

    private boolean check(int index, int length) {
        if (index < 0 || index >= length)
            return false;

        return true;
    }
}
