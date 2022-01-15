package test;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import astar.Astar;
import astar.Node;

public class Test {
	//  Initializes the map.
	
	public static void main(String[] args) {
		int map[][] = {
//				Y Axis -->
				{0,1,0,0,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				{0,0,0,1,0}
		};
		
    	System.out.println("Size: x=" + map[0].length + " y=" + map.length);
    	
    	for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
		
		long startTime = System.currentTimeMillis();
		ArrayList<Node> path = Astar.findPath(map, 0, 0, 4, 9);
		long endTime = System.currentTimeMillis();
		
		if(path == null) {
			System.out.println("Could not find path.");
		} else {
			System.out.println("Path Size: " + path.size());
			
			for(Node n : path) {
				System.out.println("Path: x-" + n.x + " y-" + n.y);
			}
			
			System.out.println("Process took: " + (endTime - startTime) + "ms");
		}
	}
}
