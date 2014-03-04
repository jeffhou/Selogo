package main;

import gui.ConsolePanel;
import gui.SlogoFrame;
import gui.WorldGraphicsPanel;
import java.io.IOException;

public class Runner {
	private static ConsolePanel interpreterGUI;
	private static WorldGraphicsPanel turtleGUI;
	
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		SlogoFrame slogoFrame = SlogoFrame.getInstance();
	}

	public static void updateTurtleGUI() {
		turtleGUI.repaint();
	}
}
