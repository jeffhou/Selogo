package commands;

import java.util.HashMap;

import backend.Engine;
import backend.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {

	final static String[] TURTLE_COMMANDS = { "forward", "fd", "back", "bk",
			"left", "lf", "right", "rt", "setheading", "seth", "towards",
			"setxy", "goto", "pendown", "pd", "penup", "pu", "showturtle",
			"st", "hideturtle", "ht", "home", "clearscreen", "cs", "xcor",
			"ycor", "heading", "pendown?", "pendownp", "showing?", "showingp" };
	Interpreter interpreter;
	Engine engine;
	public HashMap<String, String> commandClasses = new HashMap<String, String>();

	public CommandFactory(Interpreter interpreter, Engine engine) {
		this.interpreter = interpreter;
		this.engine = engine;
		/**
		 * TODO: this is duplicate code. Create a properties file or an XML file
		 * and make the factory read it instead.
		 */
		commandClasses
				.put("fd", "commands.turtleCommands.ForwardTurtleCommand");
		commandClasses.put("bk", "commands.turtleCommands.BackTurtleCommand");
		commandClasses.put("lt", "commands.turtleCommands.LeftTurtleCommand");
		commandClasses.put("rt", "commands.turtleCommands.RightTurtleCommand");
		commandClasses.put("seth",
				"commands.turtleCommands.SetHeadingTurtleCommand");
		commandClasses.put("goto", "commands.turtleCommands.GotoTurtleCommand");
		commandClasses
				.put("pd", "commands.turtleCommands.PenDownTurtleCommand");
		commandClasses.put("pu", "commands.turtleCommands.PenUpTurtleCommand");
		commandClasses.put("st",
				"commands.turtleCommands.ShowTurtleTurtleCommand");
		commandClasses.put("ht",
				"commands.turtleCommands.HideTurtleTurtleCommand");
		commandClasses.put("home", "commands.turtleCommands.HomeTurtleCommand");
		commandClasses.put("cs",
				"commands.turtleCommands.ClearScreenTurtleCommand");
	}

	public Command createCommand(String firstWord)
			throws InvalidCommandStringException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (commandClasses.containsKey(firstWord)) {
			return (Command) Class.forName(commandClasses.get(firstWord))
					.newInstance();
		}
		throw new InvalidCommandStringException();
	}

}
