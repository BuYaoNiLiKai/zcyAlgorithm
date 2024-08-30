package class01_sort;

import java.util.PriorityQueue;

import static class01_sort.Code00_SortComparator.*;

public class Code11_SortArrayDistanceLessK {
    /*
     * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
     * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
     * 请选择一个合适的排序算法针对这个数据进行排序。
     * 0 1 2 3 4 5
     */
    public static void sortArrayDistanceLessK(int[] arr, int K) {
        // java中的优先级队列 其实内部结构就是堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, K); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 10, 7, 6, 9, 8};
        sortArrayDistanceLessK(arr, 4);
        printArray(arr);

    }
}
