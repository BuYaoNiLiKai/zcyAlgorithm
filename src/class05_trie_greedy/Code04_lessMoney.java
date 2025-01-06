package class05_trie_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_lessMoney {
	// 切金条 (哈夫曼树)
	
	
	public static int lessMoney( int []arr) {
		// 准备一个小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<Integer> ();
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
		}
		int res = 0;
		int cur;
		while(heap.size()>1) {
			cur = heap.poll()+heap.poll();
			res+=cur;
			
			
			heap.add(cur);
		}
		return res;	
	}
	public static class MyHeapComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
		
	}
	public static void main(String[] args) {
	
		int []arr = {5,1,7,10,8};
		int res = lessMoney(arr);
		System.out.print(res);
	}

}
