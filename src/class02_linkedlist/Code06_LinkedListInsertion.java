package class02_linkedlist;
import class02_linkedlist.Code00_LinkedListCommon.ListNode;

public class Code06_LinkedListInsertion {
	public static ListNode getInsertionNode(ListNode head1,ListNode head2) { 
		//  两个链表的相交节点
		if(head1==null||head2==null) {
			return null;
		}
		ListNode loop1 = getLoopNode(head1);
		ListNode loop2 = getLoopNode(head2);
		
		if(loop1 == null && loop2 == null) {
			return noLoop(head1,loop1,head2,loop2);
		}
		
		if(loop1!=null&&loop2!=null) {
			return bothLoop(head1,loop1,head2,loop2);
		}
		
		return null;
	}
	private static ListNode noLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		// TODO Auto-generated method stub
		// 两个无环链表 要么平行 要么是Y
		if(loop1!=loop2) {
			// 平行
			return null;
		}
		ListNode n1 = head1;
		ListNode n2 = head2;
		int lengthGap = 0; //长度差距
		while(n1!=null) {
			lengthGap++;
			n1 = n1.next;
		}
		while(n2!=null) {
			lengthGap--;
			n2 = n2.next;
		}
		//重新指向 lengthGap>0 链表1长
		n1 = lengthGap>0? head1 : head2; //n1 指向长的链表
		n2 = n1== head1 ? head2 : head1;
		lengthGap = Math.abs(lengthGap);
		while(lengthGap>0) {
			n1 = n1.next;
			lengthGap--;
		}
		while(n1!=n2) {
			n1= n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	private static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		// TODO Auto-generated method stub
		// 两个都有环  要么是两个6 要么是Y+6 要么是电视机
		ListNode n1 = head1;
		ListNode n2 = head2;
		
		// Y+ 6 好区分
		if(loop1 == loop2) {
			// 按照尾巴是loop1 处理
			int lengthGap = 0; //长度差距
			while(n1!=loop1) {
				lengthGap++;
				n1 = n1.next;
			}
			while(n2!=loop2) {
				lengthGap--;
				n2 = n2.next;
			}
			//重新指向 lengthGap>0 链表1长
			n1 = lengthGap>0? head1 : head2; //n1 指向长的链表
			n2 = n1== head1 ? head2 : head1;
			lengthGap = Math.abs(lengthGap);
			while(lengthGap>0) {
				n1 = n1.next;
				lengthGap--;
			}
			while(n1!=n2) {
				n1= n1.next;
				n2 = n2.next;
			}
			return n1;	
		}
	
		// 区分其他两个
		// 让loop1 继续走 如果在再次回来之前 没有与loop2相遇 就是两个6
		n1= loop1.next;
		while(n1!=loop1) {
			if(n1==loop2) {
				// 相遇 就是电视机
				return loop1;
			}
			n1 =n1.next;	
		}		
		// 两个6
		return null;
	}
	// 两个链表相交问题 (可能有环)
	public static ListNode getLoopNode(ListNode head) {
		// 寻找单个链表的入环节点
		if(head ==null||head.next==null||head.next.next==null) {
			return null;
		}
		ListNode slow= head.next;
		ListNode fast = head.next.next;
		while(slow!=fast &&fast.next!=null) {
			if(fast.next ==null||fast.next.next==null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if(slow!=fast) {
			return null;
		}
		fast = head;
		while(fast!=slow) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
