package gui.menubar;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class TabMenuItem extends JMenuItem {
	TabMenuItem(){
		super("New Tab");
		addMouseListener(new LaunchNewTabMouseListener());
	}
	class LaunchNewTabMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			JTabbedPane tabbedPane = new JTabbedPane();
			ImageIcon icon = createImageIcon("images/middle.gif");

			JComponent panel1 = makeTextPanel("Panel #1");
			tabbedPane.addTab("Tab 1", icon, panel1, "Does nothing");

			JComponent panel2 = makeTextPanel("Panel #2");
			tabbedPane.addTab("Tab 2", icon, panel2, "Does twice as much nothing");

			JComponent panel3 = makeTextPanel("Panel #3");
			tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");

			JComponent panel4 = makeTextPanel(
			        "Panel #4 (has a preferred size of 410 x 50).");
			panel4.setPreferredSize(new Dimension(410, 50));
			tabbedPane.addTab("Tab 4", icon, panel4, "Does nothing at all");
		}
	}
}
