package visualize;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public window(int map[][]) {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(map[0].length * 25, map.length * 25));
		
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	public void drawSquare(int startx, int starty) {
		this.getContentPane().add(new Square(i*10, i*10, 100, 100));
		return;
	}
	
}
