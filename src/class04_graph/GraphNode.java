package class04_graph;

import java.util.ArrayList;

public class GraphNode {
	// 图节点
	public int val;
	public int in; //入度
	public int out;//出度
	public ArrayList<GraphNode> nexts; //我作为出发节点的 相邻节点
	public ArrayList<GraphEdge> edges; // 我作为出发节点的边
	public GraphNode(int val) {
		this.val = val;
		this.in = 0;
		this.out = 0;
		this.nexts = new  ArrayList<GraphNode>();
		this.edges =new  ArrayList<GraphEdge>();
	}	
}
