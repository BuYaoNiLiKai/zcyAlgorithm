package class01_sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code14_HeapTest {
    public static class AComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        // 默认为小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new AComp());
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
