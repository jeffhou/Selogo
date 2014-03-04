package gui.menubar;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuItem;


public class LoadWorkspaceMenuItem extends JMenuItem {
	LoadWorkspaceMenuItem(){
		super("Load Workspace");
//		addMouseListener(new LaunchNewTabMouseListener());
	}
//	class LaunchNewTabMouseListener extends MouseAdapter{
//		public void mousePressed(MouseEvent e) {
//			File file = new File("src/help.html");
//			Desktop desktop = Desktop.getDesktop();
//			try {
//				desktop.open(file);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}
//	}
}
