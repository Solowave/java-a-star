package astar;

public class Node {
	
	public int x, y;
	public Node parent;
	public double g, h, f;

	public Node(int x, int y, Node parent, double g, double h) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.g = g;
		this.h = h;
		this.f = g + h;
	}
	
	public boolean equals(Node refrencedNode) {
//		If the nodes are in the same position with the same parent, and the same
//		F score, than we can say they are the same.
		if(refrencedNode.x == this.x && 
				refrencedNode.y == this.y) {
			return true;
		}
		
		return false;
	}
}
