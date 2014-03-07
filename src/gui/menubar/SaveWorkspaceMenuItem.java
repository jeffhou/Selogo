package gui.menubar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JMenuItem;

import util.Serializer;
import backend.WorldsCollection;


public class SaveWorkspaceMenuItem extends JMenuItem {
	SaveWorkspaceMenuItem(){
		super("Save Workspace");
		addMouseListener(new LaunchNewTabMouseListener());
	}
	class LaunchNewTabMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				Serializer.serialize("userCommands.ser", WorldsCollection.getInstance().getCurrentWorld().getUserCommands());
				Serializer.serialize("userVariables.ser", WorldsCollection.getInstance().getCurrentWorld().getVariables());
			} catch(IOException i) {
				i.printStackTrace();
			}
		}
	}
}
