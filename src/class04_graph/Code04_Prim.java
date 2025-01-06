package class04_graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import class04_graph.Code03_Kruskal.EdgeComparator;

public class Code04_Prim {

	// prim算法 点的角度
	/*
	 * 从一个点开始 每次解锁相邻的点
	 */
	public static Set<GraphEdge> prim(Graph graph) {
		PriorityQueue<GraphEdge> queue = new PriorityQueue<GraphEdge>(
				new EdgeComparator());
		HashSet<GraphNode> set = new HashSet<>(); //解锁的点
		Set<GraphEdge> result = new HashSet<>();
		for(GraphNode node :graph.nodes.values()) {
			// 随便挑一个点 为什么循环 防止有多个森林
			if(!set.contains(node)) {
				set.add(node);
				for(GraphEdge edge:node.edges) { 
					//解锁与node节点有关的边 并且 进行排序
					queue.add(edge);
				}
				
				while(!queue.isEmpty()) {
					// 每次选取解锁的点中权重最小的边 并解锁该边的toNode
	
					GraphEdge edge = queue.poll();
					GraphNode toNode = edge.to;
					if(!set.contains(toNode)) {
						set.add(toNode);
						result.add(edge);
						// 将toNode的边解锁
						for(GraphEdge nextEdge:toNode.edges) {
							queue.add(nextEdge);
						}
					}
				}
			}	
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
