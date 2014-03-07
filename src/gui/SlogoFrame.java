package gui;

import gui.menubar.MenuBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            WorldsCollection.getInstance().switchCurrentWorld(tabbedPane.getSelectedIndex());
	            System.out.println("Selected: " + tabbedPane.getSelectedIndex());
	        }
	    });
		
	}

	public void addNewTab() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		WorldsCollection.getInstance().newWorld();
		JPanel newTab = new JPanel();
		newTab.add(new TurtleStatsPanel());
		worldGraphicsPanel = new WorldGraphicsPanel();
		newTab.add(worldGraphicsPanel);
		newTab.add(new ConsolePanel());
		tabbedPane.addTab("New Tab " + (WorldsCollection.getInstance().allWorlds.size() - 1), newTab);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
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
