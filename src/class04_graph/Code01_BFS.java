package class04_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {
	// 图的宽度优先遍历
	// 从某个节点出发进行宽度优先遍历
	public static void BFS(GraphNode node) {
		if(node==null) {
			return ;
		}
		Queue<GraphNode> queue= new LinkedList<GraphNode>();
		HashSet<GraphNode> set = new HashSet<GraphNode>();
		set.add(node);
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			System.out.println(cur.val);
			for(GraphNode next :cur.nexts) {
				if(!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
