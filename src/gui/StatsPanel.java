package gui;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import commands.UserCommand;

import backend.Interpreter;
import backend.WorldModel; import backend.WorldsCollection;

/**
 * @author Cody Lieu
 * This menu constantly updates with information about the turtle
 * and shows all user defined variables and commands
 */
public class StatsPanel extends JPanel {
	
	private JTextArea turtleStatsTextArea;
	private JTextArea variablesTextArea;
	private JTextArea userCommandsTextArea;
	
	/**
	 * Creates the text area that holds all of the turtle statistics
	 */
	StatsPanel() {
		super(new GridBagLayout());
		//this.setBorder(new LineBorder(Color.blue));
		turtleStatsTextArea = new JTextArea(10, 15);
		turtleStatsTextArea.setEditable(false);

		JScrollPane turtleStatsScrollPane = new JScrollPane(turtleStatsTextArea);
		add(turtleStatsScrollPane, SlogoDefaultConstraints.getInstance());
		
		variablesTextArea = new JTextArea(10, 15);
		variablesTextArea.setEditable(false);
		variablesTextArea.setMaximumSize(getMaximumSize());
		JScrollPane variablesScrollPane = new JScrollPane(variablesTextArea);
		
		add(variablesScrollPane, SlogoDefaultConstraints.getInstance());
		
		userCommandsTextArea = new JTextArea(10, 15);
		userCommandsTextArea.setEditable(false);
		userCommandsTextArea.setMaximumSize(getMaximumSize());
		JScrollPane userCommandsScrollPane = new JScrollPane(userCommandsTextArea);
		add(userCommandsScrollPane, SlogoDefaultConstraints.getInstance());
	
	}
	
	/**
	 * @param variables
	 * @return
	 * Creates the strings that are printed to display user defined variables
	 */
	private String getVariablesTextFromMap(Map<String, Double> variables) {
		String variablesText = "";
		for (String i : variables.keySet()){
			variablesText = variablesText + i + " : " + variables.get(i) + "\n";
		}
		return variablesText;
	}


	/**
	 * @param userCommands
	 * @return
	 * Creates the strings that are printed to display the user defined commands
	 */
	private String getUserCommandsTextFromMap(Map<String, UserCommand> userCommands) {
		String userCommandsText = "";
		for (String i : userCommands.keySet()){
			userCommandsText = userCommandsText + i + " : " + userCommands.get(i).commands + "\n";
		}
		return userCommandsText;
	}


	public void paint(Graphics g) {
		WorldModel currentWorld = WorldsCollection.getInstance().getCurrentWorld();
		
		turtleStatsTextArea.setText("Turtle Stats: \n" + currentWorld.toString());	
		
		variablesTextArea.setText("Variables: \n" + getVariablesTextFromMap(currentWorld.getVariables()));
			
		userCommandsTextArea.setText("User Commands: \n" + getUserCommandsTextFromMap(currentWorld.getUserCommands()));
	
		
	}


	
	
}

