package class01_sort;

import static class01_sort.Code00_SortComparator.*;

public class Code06_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);


    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] helpArray = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            helpArray[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] :
                    arr[rightIndex++];

        }
        while (leftIndex <= mid) {
            helpArray[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            helpArray[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < helpArray.length; i++) {
            arr[left + i] = helpArray[i];
        }

    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 1000;
        int maxValue = 10000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue, true);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking Fucked");
        int[] arr = generateRandomArray(maxSize, maxValue, true);
        mergeSort(arr);
        printArray(arr);

    }
}
