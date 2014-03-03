package Main;

import gui.SlogoGUI;
import gui.SlogoFrame;
import gui.TurtleGUI;
import gui.menubar.MenuBar;

import java.io.IOException;

public class Main {
	private static SlogoGUI interpreterGUI;
	private static TurtleGUI turtleGUI;
	
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{

		interpreterGUI = new SlogoGUI();
		turtleGUI = new TurtleGUI(interpreterGUI.interpreter.engine);

		SlogoFrame slogoFrame = new SlogoFrame(interpreterGUI, turtleGUI);

		slogoFrame.setJMenuBar(new MenuBar());
		slogoFrame.setVisible(true);

	}

	public static void updateTurtleGUI() {
		turtleGUI.repaint();
	}
}
