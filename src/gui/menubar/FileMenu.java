package gui.menubar;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class FileMenu extends JMenu {
	public FileMenu(){
		super("File");
		//add(new TabMenuItem());
		add(new SaveWorkspaceMenuItem());
		add(new LoadWorkspaceMenuItem());
	}
}
