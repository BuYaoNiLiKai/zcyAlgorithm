package class04_graph;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {
	
	public static void DFS(GraphNode node) {
		if(node==null) {
			return ;
		}
		Stack<GraphNode> stack= new Stack<GraphNode>();
		HashSet<GraphNode> set = new HashSet<GraphNode>();
		stack.add(node);
		set.add(node);
		System.out.println(node.val);
		while(!stack.isEmpty()) {
			GraphNode cur = stack.pop();
			for(GraphNode next :cur.nexts) {
				if(!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.val);
					break;
				}
			}
		}
	}


}
