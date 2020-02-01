package gui.menubar;

import gui.ColorChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class PenColorMenuItem extends JMenuItem{
  /**
   * Launches the ColorChooser menu for the user
   * to select which color they want the turtle to draw with
   */
  PenColorMenuItem(){
    super("Set Pen Color");
    addMouseListener(new LaunchPenColorSelectorMouseListener());
  }
  class LaunchPenColorSelectorMouseListener extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
      JFrame frame = new JFrame("Color Chooser");
      //Create and set up the content pane.
      ColorChooser colorChooser = new ColorChooser();
      JComponent newContentPane = colorChooser;
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
    }
  }
}
