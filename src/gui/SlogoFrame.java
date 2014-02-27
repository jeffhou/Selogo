package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import backend.Interpreter;

public class SlogoFrame {
	public InterpreterGUI myInterpretGUI;
	public TurtleGUI myTurtleGUI;
	public JFrame frame;
	
	public SlogoFrame(InterpreterGUI newInterpreterGUI, TurtleGUI newTurtleGUI) {
		myInterpretGUI = newInterpreterGUI;
		myTurtleGUI = newTurtleGUI;
		
		init();
	}
	
	public void setMenu(JMenuBar menuBar) {
		frame.setJMenuBar(menuBar);
	}
	
	
	public void setVisible() {
		frame.setVisible(true);
	}
	
	
	
	private void init() {
		
		frame = new JFrame("Slogo!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel newPanel = new JPanel();

		addGUIs(newPanel);
		frame.add(newPanel);
		// Display the window.
		frame.pack();
		frame.setSize(800,580);

		
		
	}

	private void addGUIs(JPanel newPanel) {
		newPanel.add(myTurtleGUI);
		// Add contents to the window.
		newPanel.add(myInterpretGUI);
	}
	
	

}
