package class05_trie_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;


import class05_trie_greedy.Code05_MaxProfixts.costComparator;

public class Code06_GetMiddle {
	public static class  HeapComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
		
	}
	// 在一个数据流中 随时取得中位数
	public static double[] getMiddle(int []arr) {
		// 随时获得array的中位数
		// 5 9 3 2 1 0 2 3 3 1 7 0 0 
		// 准备一个大根堆 一个小根堆
		// 确保 小根堆存储的大的半部分 大根堆存储的小的半部分
		double []res = new double[arr.length];
		PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new HeapComparator()); //大根堆
		PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
		int index = 0;
		res[index++] = arr[0];
		bigHeap.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			System.out.println( "______________________________");
			if(arr[i]<bigHeap.peek()) {
				System.out.println( arr[i]+"加入大根堆");
				bigHeap.add(arr[i]);
			}else {
				System.out.println( arr[i]+"加入大根堆");
				smallHeap.add(arr[i]);
			}
			if(Math.abs(bigHeap.size()-smallHeap.size())>=2) {
				// 交换 
				if(bigHeap.size()>smallHeap.size()) {
					System.out.println("大根堆多");
					smallHeap.add(bigHeap.poll());
				}else {
					System.out.println("小根堆多");
					bigHeap.add(smallHeap.poll());
				}
			}
			if(i%2==0) {
				res[index++] = bigHeap.size()>smallHeap.size()?bigHeap.peek():smallHeap.peek();
			}else {
				res[index++] = (smallHeap.peek()*1.0+bigHeap.peek())/2;
			}
	
			System.out.println(bigHeap.peek()+"   "+smallHeap.peek());
			System.out.println( "______________________________");
		}
		  
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {1,2,3};
		double []res = getMiddle(arr);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+ "   ");
		}
		
	}

}

