package class02_linkedlist;

import static class02_linkedlist.Code00_LinkedListCommon.*;

public class Code01_ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        //反转链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = null;
        while (tmp != null) {
            ListNode help = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = help;
        }
        return head;
    }

    public static DoublyListNode reverseDoublyLinkedList(DoublyListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoublyListNode tmp = head.next;
        head.next = null;
        while (tmp != null) {
            DoublyListNode help = tmp.next;
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
            tmp = help;
        }
        head.pre = null;
        return head;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("______________反转单向链表______________________");
        for (int i = 0; i < 10; i++) {
            ListNode head = generateRandomLinkedList(10, 10);
            printLinkedList(head);
            head = reverseLinkedList(head);
            printLinkedList(head);
            System.out.println("____________________________________");
        }
        System.out.println("_______________反转双向链表_____________________");
        for (int i = 0; i < 10; i++) {
            DoublyListNode head = generateRandomDoublyLinkedList(10, 10);
            printDoublyLinkedList(head);
            head = reverseDoublyLinkedList(head);
            System.out.println("反转后");
            printDoublyLinkedList(head);
            System.out.println("____________________________________");
        }

    }

}
