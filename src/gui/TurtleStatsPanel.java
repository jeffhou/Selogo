package gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import backend.WorldModel; import backend.WorldsCollection;

public class TurtleStatsPanel extends JPanel {
	
	private JTextArea historyTextArea;
	TurtleStatsPanel() {
		super(new GridBagLayout());
		this.setBorder(new LineBorder(Color.blue));
		historyTextArea = new JTextArea(20, 20);
		historyTextArea.setEditable(false);
		JScrollPane historyScrollPane = new JScrollPane(historyTextArea);
		add(historyScrollPane, SlogoDefaultConstraints.getInstance());
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
		drawString(g, WorldsCollection.getInstance().getCurrentWorld().toString(), 50, 50);
	}
	
}

