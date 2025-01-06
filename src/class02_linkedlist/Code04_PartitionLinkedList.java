package class02_linkedlist;

import class02_linkedlist.Code00_LinkedListCommon.ListNode;

public class Code04_PartitionLinkedList {
    // 把一个链表按照 某一值划分为三部分< = >
    public static ListNode partitionLinkedList(ListNode head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        //小、等、大 头尾
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;
        while (head != null) {
        	next =head.next;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next =head;
                    sT = sT.next;
                }

            } else if (head.val > pivot) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            }
            head = next;
        }
        // 如果有小于区域
        if(sH!=null) {
        	sT.next = eH;
        	eT  = eT==null?sT:eT;
        }
        if(eT!=null) {
        	eT.next = bH;
        }
        return sH!=null ?sH:(eH!=null?eH:bH);
    

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
