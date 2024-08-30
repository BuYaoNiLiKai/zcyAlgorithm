package class01_sort;

import static class01_sort.Code00_SortComparator.*;

public class Code10_HeapSort {
    // 堆排序
    public static void heapSort(int[] arr) {
        //
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构建大根堆
//		for(int i=0;i<arr.length;i++) {
//			heapInsert(arr,i);
//		} 
        // 更快的一种构建大根堆的方法
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        // 每次交换
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        // index和自己的父节点比较 大于就交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        // 调整堆结构
        // index处的值改变，向下调整大根堆
        int left = 2 * index + 1; // index的左孩子
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && arr[left + 1] > arr[left] ?
                    left + 1 : left; // 左右孩子的最大值
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int testTime = 50000;
        int maxSize = 1000;
        int maxValue = 10000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking Fucked");
        int[] arr = generateRandomArray(maxSize, maxValue, false);
        heapSort(arr);
        printArray(arr);
    }

}
