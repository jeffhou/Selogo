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

	Turtle turtle;
	private JTextArea historyTextArea;
	TurtleStatsGUI(Turtle turtle) {
		super(new GridBagLayout());
		this.turtle = turtle;
		this.setBorder(new LineBorder(Color.blue));
		historyTextArea = new JTextArea(20, 20);
		historyTextArea.setEditable(true);
		JScrollPane historyScrollPane = new JScrollPane(historyTextArea);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;

		add(historyScrollPane, c);
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public void paint(Graphics g) {
		g.setFont(new Font("default", Font.BOLD, 20));
		drawString(g, "TurtleStats", 20, 20);
		g.setColor(Color.BLUE);
		g.setFont(new Font("default", Font.PLAIN, 15)); 
		drawString(g, turtle.stringify(), 50, 50);
	}
	
}

