package gui.menubar;

import gui.ColorChooser;
import gui.InterpreterGUI;
import gui.menubar.PenColorMenuItem.LaunchPenColorSelectorMouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class StatsMenuItem extends JMenuItem{
	StatsMenuItem(){
		super("Turtle Stats");
		addMouseListener(new LaunchTurtleStatsDisplayMouseListener());
	}
	class LaunchTurtleStatsDisplayMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			JFrame f = new JFrame("Turtle Stats");
			f.setContentPane(InterpreterGUI.turtleStatsGUI);
			f.setSize(300,250);
			f.setVisible(true);
		}
	}
}