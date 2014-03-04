package gui.menubar;

import gui.ColorChooser;
import gui.ConsolePanel;
import gui.SlogoFrame;
import gui.menubar.PenColorMenuItem.LaunchPenColorSelectorMouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
			try {
				f.setContentPane(SlogoFrame.getInstance().turtleStatsGUI);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f.setSize(300,250);
			f.setVisible(true);
		}
	}
}