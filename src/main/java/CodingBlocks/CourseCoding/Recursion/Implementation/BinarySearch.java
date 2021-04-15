package main.java.CodingBlocks.CourseCoding.Recursion.Implementation;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {6, 10, 15, 20, 25};

        System.out.println(search(0, a.length - 1, a, 25));
    }

    private static boolean search(int s, int e, int[] a, int key) {

        if (s > e) return false;

        int mid = (s + e)/2;
        if (a[mid] == key) return true;

        if (a[mid] > key) return search(s, mid, a, key);
        else return search(mid + 1, e, a, key);
    }
}
