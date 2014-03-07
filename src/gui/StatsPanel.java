package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import commands.UserCommand;

import backend.Interpreter;
import backend.WorldModel; import backend.WorldsCollection;

public class StatsPanel extends JPanel {
	
	private JTextArea turtleStatsTextArea;
	private JTextArea variablesTextArea;
	private JTextArea userCommandsTextArea;
	
	StatsPanel() {
		super(new GridBagLayout());
		this.setBorder(new LineBorder(Color.blue));
		turtleStatsTextArea = new JTextArea(10, 15);
		turtleStatsTextArea.setEditable(false);
		JScrollPane turtleStatsScrollPane = new JScrollPane(turtleStatsTextArea);
		add(turtleStatsScrollPane, SlogoDefaultConstraints.getInstance());
		
		variablesTextArea = new JTextArea(10, 15);
		variablesTextArea.setEditable(false);
		JScrollPane variablesScrollPane = new JScrollPane(variablesTextArea);
		add(variablesScrollPane, SlogoDefaultConstraints.getInstance());
		
		userCommandsTextArea = new JTextArea(10, 15);
		userCommandsTextArea.setEditable(false);
		JScrollPane userCommandsScrollPane = new JScrollPane(userCommandsTextArea);
		add(userCommandsScrollPane, SlogoDefaultConstraints.getInstance());
	
	}
	
	private String getVariablesTextFromMap(Map<String, Double> variables) {
		String variablesText = "";
		for (String i : variables.keySet()){
			variablesText = variablesText + i + " : " + variables.get(i) + "\n";
		}
		return variablesText;
	}


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

