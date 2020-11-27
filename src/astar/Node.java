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
				refrencedNode.y == this.y && 
				refrencedNode.parent == this.parent && 
				refrencedNode.f == this.f) {
			return true;
		}
		
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}
	
	
}
