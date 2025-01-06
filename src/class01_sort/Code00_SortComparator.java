package class01_sort;

import java.util.Arrays;

public class Code00_SortComparator {
    public static int[] generateRandomArray(int maxSize, int maxValue, boolean needNegative) {
        // 产生随机数组 大小随机 值随机且存在负数

        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
            if (needNegative) {
                arr[i] -= (int) (Math.random() * (maxValue + 1));
            }
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;

    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testTime = 10;
        int maxSize = 20;
        int maxValue = 50;
        for (int i = 0; i < testTime; i++) {

            int[] arr = generateRandomArray(maxSize, maxValue, true);
            printArray(arr);
            System.out.println();
        }
    }
}
