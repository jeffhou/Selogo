package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import backend.Interpreter;

public class SlogoFrame extends JFrame{
	public SlogoGUI myInterpretGUI;
	public static TurtleGUI myTurtleGUI;

	public SlogoFrame(SlogoGUI newInterpreterGUI, TurtleGUI newTurtleGUI) {
		super("Slogo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myInterpretGUI = newInterpreterGUI;
		myTurtleGUI = newTurtleGUI;
		JPanel newPanel = new JPanel();

		addGUIs(newPanel);
		add(newPanel);
		// Display the window.
		pack();
		setSize(800,580);
	}

	private void addGUIs(JPanel newPanel) {
		newPanel.add(myTurtleGUI);
		// Add contents to the window.
		newPanel.add(myInterpretGUI);
	}
	public static void updateTurtleImage(String imagePath){
		myTurtleGUI.updateTurtleImage(imagePath);
	}

	public static void updatePenColor(Color newColor) {
		myTurtleGUI.updatePenColor(newColor);
	}


}
