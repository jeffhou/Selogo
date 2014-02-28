package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import backend.Turtle;

public class TurtleStatsGUI extends JPanel {
	

	String myContent;
	TurtleStatsGUI(String turtleStats) {
		myContent = turtleStats;
		
		this.setBorder(new LineBorder(Color.blue));
	}
	
	 private void drawString(Graphics g, String text, int x, int y) {
	        for (String line : text.split("\n"))
	            g.drawString(line, x, y += g.getFontMetrics().getHeight());
	    }

	public void updateTurtle(String turtleStats) {
		myContent = turtleStats;
	}


	public void paint(Graphics g) {
		
		g.setFont(new Font("default", Font.BOLD, 20));
		drawString(g, "TurtleStats", 20, 20);
		g.setColor(Color.BLUE);
		g.setFont(new Font("default", Font.PLAIN, 15)); 
		drawString(g, myContent, 50, 50);
		 
	}

}

