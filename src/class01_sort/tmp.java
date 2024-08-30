package class01_sort;

import java.util.LinkedList;
import java.util.Queue;

public class tmp {
    public static void main(String[] args) {
        Queue<Integer> [] queues = new Queue[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }
        for (int i = 0; i < queues.length; i++) {
            queues[i].add(i);
            queues[i].add(i+1);
        }
        for (int i = 0; i < queues.length; i++) {
            System.out.println(queues[i]);
        }
    }
}
