package gui.menubar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import gui.SlogoFrame;
import gui.menubar.ImageMenuItem.LaunchImageSelectorMouseListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.WorldsCollection;

public class LanguageMenuItem extends JMenuItem {
  String selectedLanguage;
  /**
   * @param language
   * Changes the language for input commands based
   * off the parameter passed in
   */
  LanguageMenuItem(String language){
    super(language);
    selectedLanguage = language;
    addMouseListener(new ChangeLanguageMouseListener());
  }

  class ChangeLanguageMouseListener extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
      System.out.println("Language selected is " + selectedLanguage);
      WorldsCollection.getInstance().updateLanguage(selectedLanguage);
    }
  }
}
