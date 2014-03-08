package gui.menubar;

import javax.swing.JMenu;


public class FileMenu extends JMenu {
	/**
	 * Adds the file menu specific items to the FileMenu
	 */
	public FileMenu(){
		super("File");
		add(new TabMenuItem());
		add(new CloseCurrentTabMenuItem());
		addSeparator();
		add(new SaveWorkspaceMenuItem());
		add(new LoadWorkspaceMenuItem());
		addSeparator();
		add(new SetBackgroundMenuItem());
	}
}
