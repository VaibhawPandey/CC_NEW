package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week1;

public class PlaceFlower {
    public static void main(String[] args) {
        new PlaceFlower().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0)
            return true;

        int res = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && isSatisfy(i, flowerbed.length, flowerbed)) {
                flowerbed[i] = 1;
                res++;
                if (res == n)
                    return true;
            }
        }

        return false;
    }

    private boolean isSatisfy(int i, int n, int[] flowerbed) {
        if ((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 >= n || flowerbed[i+1] == 0))
            return true;

        return false;
    }
}
