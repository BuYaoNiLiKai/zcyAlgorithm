package class04_graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class Code03_Kruskal {
	// 每次选取权重最小的边 边的角度
	public static class MySets{
		public HashMap<GraphNode,List<GraphNode>> setMap;
		public MySets(Collection<GraphNode> collection) {
			for(GraphNode node:collection) {
				List<GraphNode> set = new ArrayList<>();
				set.add(node);
				setMap.put(node,set);
			}
			
		}
		public boolean isSameSet(GraphNode from,GraphNode to) {
			return setMap.get(to) == setMap.get(from);
		}
		public void union(GraphNode from,GraphNode to) {
			List<GraphNode> fromSet = setMap.get(from);
			List<GraphNode> toSet = setMap.get(to);
			for(GraphNode toNode:toSet) {
				fromSet.add(toNode);
				setMap.put(toNode, fromSet);
			}
		}
	}
	public static class  EdgeComparator implements Comparator<GraphEdge>{

		@Override
		public int compare(GraphEdge o1, GraphEdge o2) {
			// TODO Auto-generated method stub
			return o1.weight - o2.weight;
		}
		
	}
	// 最小生成树
	public static Set<GraphEdge> Kruskal(Graph graph) {
		// 创建各自的集合
		MySets mySet = new MySets(graph.nodes.values());
		// 小根堆 按照权重排序
		PriorityQueue<GraphEdge> queue = new PriorityQueue<GraphEdge>(
				new EdgeComparator());
		// 排序
		for(GraphEdge edge:graph.edges) {
			queue.add(edge);
		}
		// 选取 合并 
		Set<GraphEdge> res = new HashSet<>();
		while(!queue.isEmpty()) {
			GraphEdge edge = queue.poll();
			if(!mySet.isSameSet(edge.from,edge.to)) {
				res.add(edge);
				mySet.union(edge.from,edge.to);
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
