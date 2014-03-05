package commands;

import java.util.HashMap;

import parser.XMLReader;
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
		XMLReader.read("assets/turtleCommands.xml", commands);
		XMLReader.read("assets/mathCommands.xml", commands);
		XMLReader.read("assets/boolCommands.xml", commands);
		XMLReader.read("assets/advancedCommands.xml", commands);
	}

}
