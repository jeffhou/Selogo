package gui;

import gui.menubar.MenuBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import backend.Interpreter;
import backend.WorldModel; import backend.WorldsCollection;
import backend.WorldsCollection;

public class SlogoFrame extends JFrame{
	// Singleton

	private static SlogoFrame instance;
	private WorldGraphicsPanel worldGraphicsPanel;
	private JTabbedPane tabbedPane;

	private SlogoFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super("Slogo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateDisplays();
		setJMenuBar(new MenuBar());
		setVisible(true);
		pack();
	}

	public static SlogoFrame getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		if(instance == null){
			instance = new SlogoFrame();
		}
		return instance;
	}
	private void populateDisplays() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		tabbedPane = new JTabbedPane();
		addNewTab();
		add(tabbedPane);
		
	}

	public void addNewTab() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		JPanel newTab = new JPanel();
		newTab.add(new TurtleStatsPanel());
		newTab.add(new WorldGraphicsPanel());
		newTab.add(new ConsolePanel());

		tabbedPane.add("New Tab", newTab);

	}
	
//	public void actionPerformed(ActionEvent e) {
//        int i = tabbedPane.indexOfTabComponent(ButtonTabComponent.this);
//        if (i != -1) {
//            tabbedPane.remove(i);
//        }
//    }

	public void updateTurtleImage(String imagePath){
		worldGraphicsPanel.updateTurtleImage(imagePath);
	}


}
