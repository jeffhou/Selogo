package gui.menubar;

import gui.SlogoFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenuItem;

public class CloseCurrentTabMenuItem extends JMenuItem {
	CloseCurrentTabMenuItem(){
		super("Close Current Tab");
		addMouseListener(new CloseCurrentTabMouseListener());
	}
	class CloseCurrentTabMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				SlogoFrame.getInstance().closeCurrentTab();
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
		}
	}

}
