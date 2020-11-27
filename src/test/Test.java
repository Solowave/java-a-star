package test;

import java.util.ArrayList;

import astar.Astar;
import astar.Node;

public class Test {
	//  Initializes the map.
	
	public static void main(String[] args) {
		int map[][] = {
				{0,1,0,0,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,0,0,1,0}
		};
		
		ArrayList<Node> path = Astar.findPath(map);
		System.out.println("Path Size: " + path.size());
		
		for(Node n : path) {
			System.out.println("Path: x-" + n.x + " y-" + n.y);
		}
	}
}
