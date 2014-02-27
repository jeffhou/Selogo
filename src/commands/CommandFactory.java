package commands;

import java.util.HashMap;

import parser.XMLReader;
import backend.Engine;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	public HashMap<String, Command> commands = new HashMap<String, Command>();
	Engine engine;
	Interpreter interpreter;

	public CommandFactory(Interpreter interpreter, Engine engine) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.interpreter = interpreter;
		this.engine = engine;
		populateCommands();
	}

	/*
	 * To match multiple strings to the same command. private ResourceBundle
	 * myCommands; public void populateCommandMap() throws IOException {
	 * myCommands = ResourceBundle.getBundle("res.Command"); Enumeration<String>
	 * bundleKeys = myCommands.getKeys(); while (bundleKeys.hasMoreElements()) {
	 * String command = (String) bundleKeys.nextElement(); commands.put(command,
	 * myCommands.getString(command)); } }
	 */

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
