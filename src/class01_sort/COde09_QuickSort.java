package class01_sort;

import static class01_sort.Code00_SortComparator.*;

public class COde09_QuickSort {
    public static void quickSort(int[] arr) {
        // 处理特殊情况
        if (arr == null || arr.length < 1) {
            return;
        }
        // 整个数组进行快排
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // partition的过程为将arr按照val划分
        //选取 划分值
        int index = left + (int) (Math.random() * (right - left));
        swap(arr, left, index);
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 1000;
        int maxValue = 10000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue, true);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking Fucked");
        int[] arr = generateRandomArray(maxSize, maxValue, true);
        quickSort(arr);
        printArray(arr);

    }

}
