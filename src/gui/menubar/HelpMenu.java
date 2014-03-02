package gui.menubar;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class HelpMenu extends JMenu {
	public HelpMenu(){
		super("Help");
		add(new HelpMenuItem());
	}
}
