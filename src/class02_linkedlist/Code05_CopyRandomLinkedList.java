package class02_linkedlist;

import java.util.HashMap;

public class Code05_CopyRandomLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public Node copyRandomLinkedList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);

    }

    public Node copyRandomLinkedListPlus(Node head) {

        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;

        // 复制一个节点 到原节点的后边
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;

        while (cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.next = next == null ? null : next.next;
            cur.next = next;
            cur = next;

        }
        return res;

    }

    // 复制含有随机指针的链表
    class Node {
        int value;
        Node next;
        Node random;

        Node(int val) {
            this.value = val;
        }
    }

}
