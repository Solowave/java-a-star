package astar;
import java.util.ArrayList;

public class Astar {	
    
//	Takes x1 x2 and y1 y2
//	Calculates the distance between the 2 points in the fastest way.
    public static double getDistance(int start_x, int start_y, int end_x, int end_y) {
		return Math.sqrt(Math.pow(start_x - end_x, 2) + Math.pow(start_y - end_y, 2));
	}
    
	public static boolean isNodeInList(ArrayList<Node> list, int x, int y) {
		for(Node newNode : list) {
			if(newNode.x == x && newNode.y == y) {
				return true;
			}
		}
		
		return false;
	}
    
    public static ArrayList<Node> findPath(int[][] map) {
    	
//    	Declares both starting and ending nodes;
        Node start_node = new Node(0, 0, null, 0, 0);
        Node end_node = new Node(4, 4, null, 0, 0);
        
//      Initializes the open and closed list.
        ArrayList<Node> openList = new ArrayList<Node>();
        ArrayList<Node> closedList = new ArrayList<Node>();
        
//      List of all possible neighbors of each node
        int possible_neighbors[][] = {
    		{-1,1},{0,1},{1,1},
    		{-1,0},{1,0},
    		{-1,-1},{0,-1},{-1,1}
        };
    	
        openList.add(start_node);
        
//      While there are nodes in the openList
        while(openList.size() > 0) {
        	
        	Node current_node = null;
        	
//        	Itterates over openList in order to find smallest node.
        	for(Node newNode : openList) {
//        		If there is no current node OR the current nodes distance value
//        		Is greater than the new one we are scanning,
        		if(current_node == null || 
        				newNode.f < current_node.f) {
//            		Set the scanned node to new current_node.
        			current_node = newNode;
        		}
        	}
        	
//        	Checks if current_node is goal.
        	if(current_node.x == end_node.x && current_node.y == end_node.y) {
        		ArrayList<Node> recurseList = new ArrayList<Node>();
        		Node recurse_node = current_node;
        		
        		while(recurse_node.parent != null) {
        			recurseList.add(recurse_node);
        			recurse_node = recurse_node.parent;
        		}

        		return recurseList;
        	}
        	
//        	Moves the node from open to closed
        	openList.remove(openList.indexOf(current_node));
        	closedList.add(current_node);
        	
//        	Itterates over the possible neighbors to populate the openList
        	for(int i = 0; i < possible_neighbors.length; i++ ) {
        		
//        		Gets X and Y position from possibleNeighbor list.
        		int moveX = possible_neighbors[i][0];
        		int moveY = possible_neighbors[i][1];
        		
//        		Calculates for new x and y of the node it is looking at.
        		int futureX = current_node.x + moveX;
        		int futureY = current_node.y + moveY;
        		
//        		Checks if node is in map.
        		if(futureX < 0 || futureY < 0 || 
        				futureY > map.length - 1 || futureX > map[0].length - 1) {
        			continue;
        		}
        		
//        		Checks if node is traversable
        		if(map[futureX][futureY] == 1){
        			continue;
        		}
        		
//        		Check if node is in closed list.
        		if(isNodeInList(closedList, futureX, futureY)) {
        			continue;
        		}
        		
//        		Gets the distance between the current node, and the neighboring node,
//        		for the g cost, AKA DISCTENCE COST
        		double g = getDistance(current_node.x, current_node.y, futureX, futureY);
        		double h = getDistance(futureX, futureY, end_node.x, end_node.y);
        		
//        		Initializes the new node with all the new information
        		Node neighboring_node = new Node(futureX, futureY, current_node, g, h);

        		boolean inOpenList = false;
        		
        		// Adds the node to the openList, recursing the program.
        		for(Node newNode : openList) {
        			if(newNode.x == futureX && newNode.y == futureY) {
        				inOpenList = true;
        				if(neighboring_node.f < newNode.f) {
        					inOpenList = false;
        				}
        			}
        		}
        		
        		if(!inOpenList) { 
        			openList.add(neighboring_node);
        		}
        		
        	}
        }
        
		return null;
    	
	}
    
}
