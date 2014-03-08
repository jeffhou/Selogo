package main;

import gui.ConsolePanel;
import gui.SlogoFrame;
import gui.WorldGraphicsPanel;
import java.io.IOException;

public class Runner {
	
	/**
	 * Main method, creates a slogoFrame, which creates the GUI
	 * @param args
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		SlogoFrame slogoFrame = SlogoFrame.getInstance();
	}
}
