package class04_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code03_ToPoSort {
	// 对一个图进行拓扑排序
	/*
	 * 每次弹出一个入度为0的节点 擦出他的影响 周而复始
	 */
	public static List<GraphNode> sortedTopology(Graph graph) {
		HashMap<GraphNode,Integer> inMap = new HashMap<GraphNode,Integer>();
		Queue<GraphNode> zeroInQueue = new 	LinkedList<GraphNode>();// 0入度节点
		for(GraphNode node:graph.nodes.values()) {
			inMap.put(node,node.in);
			if(node.in==0) {
				zeroInQueue .add(node);
			}	
		}
		List<GraphNode> res = new ArrayList<>();
		while(!zeroInQueue.isEmpty()) {
			GraphNode cur = zeroInQueue.poll();
			res.add(cur);
			for(GraphNode node:cur.nexts) {
				inMap.put(node,inMap.get(node)-1);
				if(inMap.get(node)==0) {
					zeroInQueue.add(node);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
