package main.java.CodingBlocks.CourseCoding.DivideAndConquer;

public class BookAllocation {
    public static void main(String[] args) {
        int n = 4, m = 2, books[] = {10, 20, 30, 40};

        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += books[i];
            max = Math.max(max, books[i]);
        }

        // S = max because if the student read at least 1 book then he have to read at least 40 pages
        int s = max, e = sum, ans = -1;
        while (s <= e) {

            int mid = (s + e)/2;
            boolean isAdjustPossible = adjustPossible(books, m, n, mid);
            if (isAdjustPossible) {
                ans = mid;
                e = mid - 1;
            }
            else
                s = mid + 1;
        }

        System.out.println(ans);

    }

    private static boolean adjustPossible(int[] books, int noOfStudent, int n, int mid) {
        int cnt = 1, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += books[i];
            if (sum > mid) {
                sum = books[i];
                cnt++;
            }

            if (cnt > noOfStudent)
                break;
        }

        return cnt == noOfStudent;
    }
}
