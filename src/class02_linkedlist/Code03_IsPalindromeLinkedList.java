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
            stack.add(tmp.val);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop()) {
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
        // 寻找中点 快指针到头的时候 慢指针来到中点位置  快指针先来到终点
        ListNode n1 = head; //慢指针
        ListNode n2 = head; // 快指针
    

        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
        }
        
        // 慢指针来到中点位置 翻转n1之后链表
        
        n2 = n1.next; // 右半部分第一个节点
        n1.next = null;
        ListNode n3 = null;
        while(n2!=null) {
        	n3 = n2.next;
        	n2.next = n1;
        	n1= n2;
        	n2 = n3;
        }
        // n1来到了最后一个节点
        n3 = n1;
        n2 = head;
        boolean res = true;
        while(n2!=null&&n1!=null) {
        	if(n2.val!=n1.val) {
        		res =  false;
        	}
        	n2 = n2.next;
        	n1 = n1.next;
        }
        
        // 翻转回去
        n1 =  n3.next;
        n3.next = null;
       
        while(n1!= null) {
        	n2 = n1.next;
        	n1.next = n3;
        	n3 = n1;
        	n1 = n2;
        	
        }
        return res;

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
