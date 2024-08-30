package class01_sort;

import static class01_sort.Code00_SortComparator.*;

public class Code08_NetherlandsFlag {
    public static void netherlandsFlag(int[] arr, int pivot) {
        // 将数组array划分 左侧小于等于pivot 右侧大于pivot
        int smallIndex = 0; // 记录<=区域的边界
        int scanIndex = 0; // 负责全局
        while (scanIndex < arr.length) {
            if (arr[scanIndex] <= pivot) {
                swap(arr, smallIndex, scanIndex);
                smallIndex++;
            }
            scanIndex++;
            printArray(arr);
            System.out.println();
        }
    }

    public static void netherlandsFlagPlus(int[] arr, int pivot) {
        // 将数组array划分 左侧小于pivot 中间等于pivot 右侧大于pivot

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {3, 5, 6, 7, 4, 3, 5, 8};
        netherlandsFlag(arr, 5);
        printArray(arr);
    }

}
