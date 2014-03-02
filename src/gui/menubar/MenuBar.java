package gui.menubar;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	public MenuBar(){
		add(new HelpMenu());
		add(new TurtleMenu());
	}
}
