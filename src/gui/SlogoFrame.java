package gui;

import gui.menubar.MenuBar;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import backend.Interpreter;

public class SlogoFrame extends JFrame{
	// Singleton
	
	private static SlogoFrame instance;
	public ConsolePanel consolePanel;
	public WorldGraphicsPanel worldGraphicsPanel;

	private SlogoFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		super("Slogo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consolePanel = new ConsolePanel();
		worldGraphicsPanel = new WorldGraphicsPanel(consolePanel.interpreter.engine);
		JPanel newPanel = new JPanel();

		addGUIs(newPanel);
		add(newPanel);
		setJMenuBar(new MenuBar());
		setVisible(true);
		pack();
		setSize(800,580);
		
	}
	
	public static SlogoFrame getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		if(instance == null){
			instance = new SlogoFrame();
		}
		return instance;
	}
	private void addGUIs(JPanel newPanel) {
		newPanel.add(worldGraphicsPanel);
		// Add contents to the window.
		newPanel.add(consolePanel);
	}
	public void updateTurtleImage(String imagePath){
		worldGraphicsPanel.updateTurtleImage(imagePath);
	}

	public void updatePenColor(Color newColor) {
		worldGraphicsPanel.updatePenColor(newColor);
	}


}
