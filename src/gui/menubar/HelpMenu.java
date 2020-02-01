package gui.menubar;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
  /**
   * Creates the help menu and adds the Documentation menu item
   */
  public HelpMenu(){
    super("Help");
    add(new HelpMenuItem());
  }
}
