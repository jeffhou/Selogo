package gui.menubar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import util.Serializer;
import backend.WorldsCollection;


public class SaveWorkspaceMenuItem extends JMenuItem {
	SaveWorkspaceMenuItem(){
		super("Save Workspace");
		addMouseListener(new LaunchNewTabMouseListener());
	}
	class LaunchNewTabMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			
			String s = (String) JOptionPane.showInputDialog(null, "Name the serialization file: (no extension needed)", "Save Workspace...", JOptionPane.QUESTION_MESSAGE, null, null, "file name");
			try {
				Serializer.serialize("serializedFiles/" + s + ".ser", WorldsCollection.getInstance().getCurrentWorld().getUserCommands());
				Serializer.serialize("serializedFiles/" + s + ".ser" + "v", WorldsCollection.getInstance().getCurrentWorld().getVariables());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}