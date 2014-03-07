package gui.menubar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenuItem;

import util.Serializer;
import backend.WorldsCollection;


public class LoadWorkspaceMenuItem extends JMenuItem {
	LoadWorkspaceMenuItem(){
		super("Load Workspace");
		addMouseListener(new LaunchNewTabMouseListener());
	}
	class LaunchNewTabMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				WorldsCollection.getInstance().getCurrentWorld().setUserCommands(Serializer.deserialize("userCommands.ser"));
				WorldsCollection.getInstance().getCurrentWorld().setVariables(Serializer.deserialize("userVariables.ser"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
