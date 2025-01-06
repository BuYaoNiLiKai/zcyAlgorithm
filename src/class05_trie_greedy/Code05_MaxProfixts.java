package class05_trie_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_MaxProfixts {
	// 最大利润
	/*
	 * 给定数组  cost[] 和 profit[] 
	 * cost为该项目的花费  profit为该项目 能得到的利润
	 * 给定初始资金 money 
	 * k 为最多做几个项目
	 * 问怎么做能够在这些项目中得到最大利润 
	 */
	public static class Node{
		int cost;
		int profit;
		public Node(int c,int p) {
			cost = c;
			profit = p;	
		}
	}
	public static class costComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			// cost小根堆
			return o1.cost-o2.cost;
		}	
	}
	public static class profitComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			// cost小根堆
			return o2.profit - o1.profit;
		}
	}
	public static int maxProfit( int[]costs,int []profits,int money,int k) {
		//  准备一个大根堆 和一个cost小根堆 
		PriorityQueue<Node> costHeap = new PriorityQueue<>(new costComparator());
		PriorityQueue<Node> profittHeap = new PriorityQueue<>(new profitComparator());
		for(int i=0;i<costs.length;i++){
			costHeap .add(new Node(costs[i],profits[i]));
		}
		for(int i=0;i<k;i++) {
			while(!costHeap.isEmpty()&&costHeap.peek().cost<=money) {
				profittHeap.add(costHeap.poll());	
			}	
			if(profittHeap.isEmpty()) {
				return money; // 没有能做的项目了
			}
			money +=profittHeap.poll().profit;
		
		}
		return money;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
