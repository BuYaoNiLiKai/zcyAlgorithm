package class02_linkedlist;


import class02_linkedlist.Code00_LinkedListCommon.ListNode;

public class CodeTmp_mergeKlinkedList {
	
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode res = null;
    	ListNode cur = null;
    	int usefulNums= lists.length;
    	for(int i=0;i<lists.length;i++) {
    		if(lists[i]==null) {
    			usefulNums--;
    		}
    	}
    	while(usefulNums>0) {
    		int minIndex = -1;
    		int minVal = Integer.MAX_VALUE;
    		// 找最小值
    		for(int i=0;i<lists.length;i++) {
    			if(lists[i]!=null&&lists[i].val<minVal){  //还有元素
    					minVal = lists[i].val;
    					minIndex = i;
    			}
    		}

    		if(res ==null) {
    			res = new ListNode(minVal);
    			cur =res;
    		}else {
    			cur.next = new ListNode(minVal);
    			cur = cur.next;
    		}
    		if(lists[minIndex].next == null) {
    			usefulNums--;
    		}
    		lists[minIndex] = lists[minIndex].next;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode l4 = new ListNode(-1);
		ListNode []lists = {l1,l2,l3,l4};
		CodeTmp_mergeKlinkedList  run = new CodeTmp_mergeKlinkedList();
		run.mergeKLists(lists);


	}

}
