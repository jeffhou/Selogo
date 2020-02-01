package gui.menubar;

import gui.SlogoFrame;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.WorldsCollection;
import main.Runner;

public class ImageMenuItem extends JMenuItem{
  /**
   * Creates a JFileChooser that lets the user choose
   * which image file to use for the turtle
   */
  ImageMenuItem(){
    super("Set Turtle Image");
    addMouseListener(new LaunchImageSelectorMouseListener());
  }
  class LaunchImageSelectorMouseListener extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
      final JFileChooser chooser = new JFileChooser("img");
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
          "JPG, GIF, and PNG images", "jpg", "gif", "png");
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(null);

      if(returnVal == JFileChooser.APPROVE_OPTION) {
        File chosenFile = chooser.getSelectedFile();
        String absolutePath = chosenFile.getAbsolutePath();
          try {
            WorldsCollection.getCurrentWorld().updateTurtleImage(absolutePath);
            SlogoFrame.getInstance().repaint();
          } catch (Exception e1) {
            e1.printStackTrace();
          }
      }
    }
  }
}
