package gui.menubar;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	public MenuBar(){
		add(new FileMenu());
		add(new TurtleMenu());
		add(new HelpMenu());
		add(new LanguageMenu());
	}
}
