package class01_sort;

import static class01_sort.Code00_SortComparator.*;

import java.util.LinkedList;
import java.util.Queue;

public class Code12_RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, maxbits(arr));
    }

    public static void radixSortPlus(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSortPlus(arr, 0, arr.length - 1, maxbits(arr));
    }

    // 基础版桶排序
    public static void radixSort(int[] arr, int maxbits) {
        Queue<Integer>[] buckets = new Queue[10];
        // 初始化桶buckets
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }
        // 最多进桶出桶的次数
        for (int i = 1; i <= maxbits; i++) {

            // 根据第digit位的数放入对应的桶中
            for (int j = 0; j < arr.length; j++) {
                buckets[getDigit(arr[j], i)].add(arr[j]);
            }
            // 出桶
            int index = 0;
            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()) {
                    arr[index++] = buckets[j].poll();
                }
            }
        }
    }

    // 升级版桶排序
    public static void radixSortPlus(int[] arr, int left, int right, int digits) {
        final int radix = 10;
        int[] bucket = new int[right - left + 1]; // 辅助数组
        for (int i = 1; i <= digits; i++) { //几轮进桶出桶
            int[] count = new int[radix];
            for (int j = left; j <= right; j++) {
                count[getDigit(arr[j], i)]++;  //入桶
            }
            for (int j = 1; j < radix; j++) {
                // 计算前缀和
                count[j] += count[j - 1];
            }
            for (int j = right; j >= left; j--) {
                bucket[--count[getDigit(arr[j], i)]] = arr[j];
            }
            for (int j = left; j <= right; j++) {
                arr[j] = bucket[j];
            }
        }

    }

    public static int maxbits(int[] arr) {
        // 获取数组array中最大值的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int res = 0;
        while (max > 0) {
            max /= 10;
            res++;
        }
        return res;
    }

    public static int getDigit(int value, int digit) {
        // 获取value第digit位的值 例如 value 456 digit= 1->6
        int radix = 1;
        for (int i = 1; i < digit; i++) {
            radix *= 10;
        }
        return (value / radix) % 10;

    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 1000;
        int maxValue = 10000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = copyArray(arr1);
            radixSortPlus(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking Fucked");
        int[] arr = generateRandomArray(maxSize, maxValue, false);
        radixSortPlus(arr);
        printArray(arr);
    }

}
