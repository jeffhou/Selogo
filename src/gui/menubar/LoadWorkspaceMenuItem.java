package gui.menubar;

import gui.SlogoFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.Serializer;
import backend.WorldsCollection;


public class LoadWorkspaceMenuItem extends JMenuItem {
  /**
   * Loads a workspace saved by the user that
   * contains user defined variables and commands
   */
  LoadWorkspaceMenuItem(){
    super("Load Workspace");
    addMouseListener(new LaunchNewTabMouseListener());
  }
  class LaunchNewTabMouseListener extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
      final JFileChooser chooser = new JFileChooser("serializedFiles");
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
          "Serialization Files", "ser");
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(null);

      if(returnVal == JFileChooser.APPROVE_OPTION) {
        File chosenFile = chooser.getSelectedFile();
        String absolutePath = chosenFile.getAbsolutePath();
        try {
          WorldsCollection.getCurrentWorld().setUserCommands(Serializer.deserialize(absolutePath));
          WorldsCollection.getCurrentWorld().setVariables(Serializer.deserialize(absolutePath + "v"));
          SlogoFrame.getInstance().repaint();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }
}
