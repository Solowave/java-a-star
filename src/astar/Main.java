package astar;
import java.util.ArrayList;

public class Main {	
    
    public static double getDistance(int sx, int sy, int ex, int ey) {
		return Math.sqrt(Math.pow(sx - ex, 2) + Math.pow(sy - ey, 2));
	}
    
    public static void main(String[] args) {
	
        Node start_node = new Node(0, 0, null, 0, 0);
        Node end_node = new Node(4, 4, null, 0, 0);
        
        ArrayList<Node> openList = new ArrayList<Node>();
        ArrayList<Node> closedList = new ArrayList<Node>();
        
        int map[][] = {
        		{0,1,0,0,0},
        		{0,1,0,0,0},
        		{0,1,0,0,0},
        		{0,1,1,1,1},
        		{0,0,0,0,0}
        };
        
        int possible_neighbors[][] = {
    		{-1,1},{0,1},{1,1},
    		{-1,0},{1,0},
    		{-1,-1},{0,-1},{-1,1}
        };
    	
        openList.add(start_node);
        
        while(openList.size() > 0) {
        	
        	Node current_node = null;
        	
        	for(Node n : openList) {
        		if(current_node == null || 
        				n.f < current_node.f) {
        			current_node = n;
        		}
        	}
        	
        	if(current_node.x == end_node.x && current_node.y == end_node.y) {
//        		ArrayList<Node> recurseList = new ArrayList<Node>();
        		Node recurse_node = current_node;
        		int steps = 1;
        		
        		while(recurse_node.parent != null) {
//        			recurseList.add(recurse_node);
        			System.out.println("step: " + steps + " | " + recurse_node.x + " : " + recurse_node.y);
        			
        			steps++;
        			recurse_node = recurse_node.parent;
        		}

        		return;
        	}
        	
        	openList.remove(openList.indexOf(current_node));
        	closedList.add(current_node);
        	
        	for(int i = 0; i < possible_neighbors.length; i++ ) {
        		int moveX = possible_neighbors[i][0];
        		int moveY = possible_neighbors[i][1];
        		
        		int futureX = current_node.x + moveX;
        		int futureY = current_node.y + moveY;
        		
        		System.out.println(futureX + " : " + futureY);
        		
        		if(futureX < 0 || futureY < 0 || 
        				futureY > map.length - 1 || futureX > map[0].length - 1) {
        			continue;
        		}
        		
        		if(map[futureX][futureY] == 1){
        			continue;
        		}
        		
//        		Gets the distance between the current node, and the neighboring node,
//        		for the g cost, AKA DISCTENCE COST
        		double g = getDistance(current_node.x, current_node.y, futureX, futureY);
        		double h = getDistance(futureX, futureY, end_node.x, end_node.y);
        		
        		Node neighboring_node = new Node(futureX, futureY, current_node, g, h);
        		openList.add(neighboring_node);
        	}
        }
        
        System.out.println("Couldn't finish...");
		return;
    	
	}
    
}
