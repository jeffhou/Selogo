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

import main.Runner;

public class ImageMenuItem extends JMenuItem{
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
				String pathOfFile = chosenFile.getAbsolutePath();
					try {
						SlogoFrame.getInstance().updateTurtleImage(pathOfFile);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// TODO Auto-generated catch block
			}
		}
	}
}
