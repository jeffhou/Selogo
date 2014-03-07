package gui.menubar;

import javax.swing.JMenu;

public class LanguageMenu extends JMenu {
	public LanguageMenu(){
		super("Language");
		add(new LanguageMenuItem("English"));
		add(new LanguageMenuItem("French"));
		add(new LanguageMenuItem("Italian"));
		add(new LanguageMenuItem("Portuguese"));
		add(new LanguageMenuItem("German"));
		
	}

}
