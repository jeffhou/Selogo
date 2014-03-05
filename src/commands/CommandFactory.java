package commands;

import java.util.HashMap;

import parser.XMLReader;
import backend.CommandInvoker;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	public HashMap<String, Command> commands = new HashMap<String, Command>();

	public CommandFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		populateCommands();
	}

	public Command createCommand(String firstWord)
			throws InvalidCommandStringException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (commands.containsKey(firstWord)) {
			return commands.get(firstWord);
		}
		throw new InvalidCommandStringException();
	}

	public void populateCommands() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		XMLReader newXMLReader = new XMLReader();
		newXMLReader.read("assets/turtleCommands.xml", commands);
		newXMLReader.read("assets/mathCommands.xml", commands);
		newXMLReader.read("assets/boolCommands.xml", commands);
		newXMLReader.read("assets/advancedCommands.xml", commands);
	}

}
