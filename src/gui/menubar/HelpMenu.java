package gui.menubar;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
	public HelpMenu(){
		super("Help");
		add(new HelpMenuItem());
	}
}
