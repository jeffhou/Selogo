package commands;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import backend.Engine;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	final static String[] TURTLE_COMMANDS = { "forward", "fd", "back", "bk",
			"left", "lt", "right", "rt", "setheading", "seth", "towards",
			"setxy", "goto", "pendown", "pd", "penup", "pu", "showturtle",
			"st", "hideturtle", "ht", "home", "clearscreen", "cs", "xcor",
			"ycor", "heading", "pendown?", "pendownp", "showing?", "showingp" };
	Interpreter interpreter;
	Engine engine;
	public Map<String, String> commands = new HashMap<String, String>();
	private ResourceBundle myCommands;

	public void populateCommandMap() throws IOException {
		myCommands = ResourceBundle.getBundle("res.Command");
		Enumeration<String> bundleKeys = myCommands.getKeys();
		while (bundleKeys.hasMoreElements()) {
			String command = (String) bundleKeys.nextElement();
			commands.put(command, myCommands.getString(command));
		}
	}

	public CommandFactory(Interpreter interpreter, Engine engine)
			throws IOException {
		this.interpreter = interpreter;
		this.engine = engine;
		populateCommandMap();
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
