package astar;

public class Node {
	
	int x, y;
	Node parent;
	double g, h, f;

	public Node(int x, int y, Node parent, double g, double h) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.g = g;
		this.h = h;
		this.f = g + h;
	}
	
	public Node getParent() {
		return this.parent;
	}
}
