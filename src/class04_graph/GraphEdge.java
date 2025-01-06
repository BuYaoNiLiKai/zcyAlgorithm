package class04_graph;

public class GraphEdge {

	public GraphNode from;
	public GraphNode to;
	int weight;
	public GraphEdge(GraphNode from,GraphNode to,int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
		
	}

}
