package class04_graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Code05_Dijistr {
	public static HashMap<GraphNode ,Integer> dijistra(GraphNode node) {
		//从node到其他点的最短距离
		/*
		 * distanMap key: 节点
		 * value :node 到节点的距离
		 */
		
		HashMap<GraphNode ,Integer> distanceMap = new HashMap<>();
		HashSet<GraphNode> selectedNodes = new HashSet<>(); //已经有结果的节点
		distanceMap.put(node,0); //到自己的距离是0  一行距离 没有就是∞
		
		GraphNode minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
		while(minNode!=null) {
			// 解锁边
			int distance = distanceMap.get(minNode);
			
			for(GraphEdge edge:minNode.edges) {
				GraphNode toNode = edge.to;
				if(!distanceMap.containsKey(toNode)) {
					// 如果表中无数据 则添加
					distanceMap.put(toNode, distance+edge.weight);
				}
				// 之前的某条路径 与当前新找到的路做比较
				distanceMap.put(edge.to,Math.min(distanceMap.get(toNode), 
						distance+edge.weight));
			}
			selectedNodes.add(minNode); //锁定节点
			minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
		}
		return distanceMap;
		
	}
	public static GraphNode getMinDistanceAndUnselectedNode(
			HashMap<GraphNode,Integer> distanceMap,HashSet<GraphNode> selectedNodes){
		int minDistance = Integer.MAX_VALUE;
		GraphNode minNode = null;
		for(Entry<GraphNode,Integer> entry:distanceMap.entrySet()) {
			GraphNode node = entry.getKey();
			int distance = entry.getValue();
			if(!selectedNodes.contains(node)&&distance<minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
