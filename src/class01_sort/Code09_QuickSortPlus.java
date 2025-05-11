package class01_sort;

import static class01_sort.Code00_SortComparator.comparator;
import static class01_sort.Code00_SortComparator.copyArray;
import static class01_sort.Code00_SortComparator.generateRandomArray;
import static class01_sort.Code00_SortComparator.isEqual;
import static class01_sort.Code00_SortComparator.printArray;
import static class01_sort.Code00_SortComparator.swap;

public class Code09_QuickSortPlus {

    public static void quickSortPlus(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortPlus(arr, 0, arr.length - 1);
    }

    public static void quickSortPlus(int[] arr, int left, int right) {
        if (left < right) {
            int[] sides = partition(arr, left, right);// 边界
            quickSortPlus(arr, left, sides[0]);
            quickSortPlus(arr, sides[1], right);
        }

    }

    public static int[] partition(int[] arr, int left, int right) {
        // 在数组arr left到right范围内，按照某一划分值，将数组划分为3部分
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = arr[pivotIndex];
        int smallIndex = left - 1;
        int bigIndex = right + 1;
        int scanIndex = left;
        while (scanIndex < bigIndex) {
            if (arr[scanIndex] < pivot) {
                swap(arr, scanIndex++, ++smallIndex);
            } else {
                if (arr[scanIndex] == pivot) {
                    scanIndex++;
                } else {
                    swap(arr, scanIndex, --bigIndex);
                }
            }
        }

        return new int[]{smallIndex, bigIndex};

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int testTime = 500000;
        int maxSize = 10000;
        int maxValue = 100000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue, true);
            int[] arr2 = copyArray(arr1);
            quickSortPlus(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking Fucked");
        int[] arr = generateRandomArray(maxSize, maxValue, true);
        quickSortPlus(arr);
        printArray(arr);
    }

}
