package class04_graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer,GraphNode> nodes;
	public HashSet<GraphEdge> edges;
	public Graph() {
		nodes = new HashMap<Integer,GraphNode>();
		edges = new HashSet<GraphEdge>();
	}
}
