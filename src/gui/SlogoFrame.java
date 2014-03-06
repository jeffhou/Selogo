package gui;

import gui.menubar.MenuBar;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import backend.Interpreter;
import backend.WorldModel; import backend.WorldsCollection;
import backend.WorldsCollection;

public class SlogoFrame extends JFrame{
	// Singleton
	
	private static SlogoFrame instance;
	private WorldGraphicsPanel worldGraphicsPanel;

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
		JPanel newPanel = new JPanel();
		newPanel.add(new TurtleStatsPanel());
		worldGraphicsPanel = new WorldGraphicsPanel();
		newPanel.add(worldGraphicsPanel);
		newPanel.add(new ConsolePanel());
		add(newPanel);
	}
	public void updateTurtleImage(String imagePath){
		worldGraphicsPanel.updateTurtleImage(imagePath);
	}


}
