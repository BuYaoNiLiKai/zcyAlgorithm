package class02_linkedlist;

import static class02_linkedlist.Code00_LinkedListCommon.*;
import static class01_sort.Code10_HeapSort.heapSort;
import static class01_sort.Code00_SortComparator.*;

public class Code02_PrintOrderedLinkedListCommon {
	//	打印两个有序链表的公共部分
	

    public static void printOrderedLinkedListCommon(ListNode l1, ListNode l2) {
        ListNode head1 = l1; // 1号链表
        ListNode head2 = l2; // 2号链表
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                // 小于
                head1 = head1.next;
            } else if (head1.val == head2.val) {
                // 相等打印
                System.out.print(head1.val + "  ");
                head1 = head1.next;
                head2 = head2.next;
            } else {
                // 大于
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 10;
        for (int i = 1; i <= testTime; i++) {
            int[] arr1 = generateRandomArray(10, 10, false); // 第一个数组
            int[] arr2 = generateRandomArray(10, 10, false); // 第二个数组
            heapSort(arr1); // 对数组进行排序s
            heapSort(arr2); // 对数组进行排序
            ListNode l1 = copyArrayToLinkedList(arr1);
            ListNode l2 = copyArrayToLinkedList(arr2);
            System.out.println("两个有序链表为:");
            printLinkedList(l1);
            printLinkedList(l2);
            System.out.println("两个有序链表的公共部分为:");
            printOrderedLinkedListCommon(l1, l2);
            System.out.println("________________________");
        }


    }
}
