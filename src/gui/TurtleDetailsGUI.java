package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import backend.Turtle;

public class TurtleDetailsGUI extends JPanel {
	

	String myContent;
	TurtleDetailsGUI(Turtle turtletoDisplay) {
		myContent = turtletoDisplay.stringify();
		
		
	}
	
	 private void drawString(Graphics g, String text, int x, int y) {
	        for (String line : text.split("\n"))
	            g.drawString(line, x, y += g.getFontMetrics().getHeight());
	    }

	public void updateTurtle(Turtle turtletoDisplay) {
		myContent = turtletoDisplay.stringify();
	}


	public void paint(Graphics g) {
		g.setFont(new Font("default", Font.BOLD, 20));
		drawString(g, "TurtleStats", 20, 20);
		g.setFont(new Font("default", Font.PLAIN, 15)); 
		drawString(g, myContent, 50, 50);
		 
	}

}

