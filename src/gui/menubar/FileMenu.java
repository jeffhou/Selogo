package gui.menubar;

import javax.swing.JMenu;


public class FileMenu extends JMenu {
	public FileMenu(){
		super("File");
		//add(new TabMenuItem());
		add(new SaveWorkspaceMenuItem());
		add(new LoadWorkspaceMenuItem());
	}
}
