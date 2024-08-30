package class02_linkedlist;

import static class02_linkedlist.Code00_LinkedListCommon.*;

import java.util.Stack;

public class Code03_IsPalindromeLinkedList {
    public static boolean isPalindromeLinkedList(ListNode head) {
        // 判断一个链表是否为回文链表  压到栈里面 在弹出 需要辅助空间
        /* 1 2 2 1 -> true
         * 1 2 3 1 -> false
         * null ->true
         * 1 -> true
         * 1 2 1-> true
         * */
        if (head == null || head.next == null) {
            return true;
        }
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        while (tmp != null) {
            stack.add(tmp.value);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeLinkedListPlus(ListNode head) {
        /* 升级版本 使用快慢指针  慢指针走一步 快指针走两步
         * 快慢指针 需要注意 当快指针走到头的时候慢指针停的地方
         *  分析 Node 个数为 0 1 2 3 和>=3 的部分讨论就好
         *  1 1  慢指针指向 第一个1
         *  1 2 1 慢指针指向2
         *  1 2 2 1  慢指针指向第一个2
         *  1 2 3 2 1 慢指针 指向3
         */

        if (head == null || head.next == null) {
            // 链表长度为0、1的情况
            return true;
        }
        // 寻找中点
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        return true;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ListNode head = generateRandomLinkedList(1, 10);
            printLinkedList(head);
            System.out.println(isPalindromeLinkedList(head));
            System.out.println("_______________________");
        }
    }
}
