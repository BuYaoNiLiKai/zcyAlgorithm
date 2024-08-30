package class02_linkedlist;

public class Code00_LinkedListCommon {
    public static class ListNode {
        public ListNode next;
        public int value;

        public ListNode() {
            this.value = 0;
            this.next = null;
        }

        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public static class DoublyListNode {
        public DoublyListNode next;
        public DoublyListNode last;
        public int value;

        public DoublyListNode(int val) {
            this.value = val;
            this.next = null;
            this.last = null;
        }
    }

    public static ListNode generateRandomLinkedList(int maxValue, int maxSize) {
        int size = (int) (Math.random() * (maxSize + 1));
        if (size == 0) {
            return null;
        }
        int val = (int) (Math.random() * (maxValue + 1));
        ListNode head = new ListNode(val);
        ListNode tmp = head;
        for (int i = 1; i < size; i++) {
            val = (int) (Math.random() * (maxValue + 1));
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }
        return head;
    }

    public static DoublyListNode generateRandomDoublyLinkedList(int maxValue, int maxSize) {
        int size = (int) (Math.random() * (maxSize + 1));
        if (size == 0) {
            return null;
        }
        int val = (int) (Math.random() * (maxValue + 1));
        DoublyListNode head = new DoublyListNode(val);
        DoublyListNode tmp = head;
        for (int i = 1; i < size; i++) {
            val = (int) (Math.random() * (maxValue + 1));
            DoublyListNode insertNode = new DoublyListNode(val);
            insertNode.last = tmp;
            tmp.next = insertNode;
            tmp = insertNode;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoublyLinkedList(DoublyListNode head) {
        System.out.println("从前往后打印:");
        while (head != null) {
            System.out.print(head.value + " ");
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        System.out.println();
        System.out.println("从后往前打印:");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.last;
        }
        System.out.println();
        System.out.println("_____________________________");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            ListNode head = generateRandomLinkedList(1, 10);
            printLinkedList(head);
        }
        System.out.println("打印双向链表");
        for (int i = 0; i < 10; i++) {
            DoublyListNode head1 = generateRandomDoublyLinkedList(10, 10);
            printDoublyLinkedList(head1);
        }
    }

}
