package vn.hoctotlamhay.utils;

public class ArrayUtils {
    /**
     * Tính tổng các số nguyên từ 1 đến 1000.
     */
    public static long sumArray() {
        long total = 0;
        for (int i = 1; i <= 1000; i++) {
            total += i;
        }
        return total;
    }
}