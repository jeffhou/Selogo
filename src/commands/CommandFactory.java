package commands;

import java.util.HashMap;
import parser.XMLReader;
import backend.Engine;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	Interpreter interpreter;
	Engine engine;
	public HashMap<String, String> commands = new HashMap<String, String>();

	public void populateCommands() {
		XMLReader newXMLReader = new XMLReader();
		newXMLReader.read("assets/turtleCommands.xml", commands);
		newXMLReader.read("assets/mathCommands.xml", commands);
		newXMLReader.read("assets/boolCommands.xml", commands);

	}

	/*
	 * To match multiple strings to the same command. private ResourceBundle
	 * myCommands; public void populateCommandMap() throws IOException {
	 * myCommands = ResourceBundle.getBundle("res.Command"); Enumeration<String>
	 * bundleKeys = myCommands.getKeys(); while (bundleKeys.hasMoreElements()) {
	 * String command = (String) bundleKeys.nextElement(); commands.put(command,
	 * myCommands.getString(command)); } }
	 */

	public CommandFactory(Interpreter interpreter, Engine engine) {
		this.interpreter = interpreter;
		this.engine = engine;
		populateCommands();
	}

	public Command createCommand(String firstWord)
			throws InvalidCommandStringException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (commands.containsKey(firstWord)) {
			return (Command) Class.forName(commands.get(firstWord))
					.newInstance();
		}
		throw new InvalidCommandStringException();
	}

}
