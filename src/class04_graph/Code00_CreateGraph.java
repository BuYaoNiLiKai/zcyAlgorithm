package class04_graph;

public class Code00_CreateGraph {
	// 其他图结构 转换为自己的图结构
	/*
	 * matrix 是N*3的矩阵 arr[x][0] arr[x][1] arr[x][2] 连街边的两个节点和权重
	 */
	public static Graph createGraph(int [][]matrix) {
		Graph graph = new Graph();
		for(int i = 0;i<matrix.length;i++) {
			int from = matrix[i][0];
			int to =  matrix[i][1];
			int weight = matrix[i][2];
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from,new GraphNode(from));
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to,new GraphNode(to));
			}
			GraphNode fromNode = graph.nodes.get(from);
			GraphNode toNode = graph.nodes.get(to);
			GraphEdge newEdge = new GraphEdge(fromNode,toNode,weight);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);

		}
		return graph;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
