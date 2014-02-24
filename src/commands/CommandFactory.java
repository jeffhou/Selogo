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
	public HashMap<String, String> commands = new HashMap<String, String>();

	public CommandFactory(Interpreter interpreter, Engine engine) {
		this.interpreter = interpreter;
		this.engine = engine;
		/**
		 * TODO: this is duplicate code. Create a properties file or an XML file
		 * and make the factory read it instead.
		 */
		commands.put("fd", "commands.turtleCommands.ForwardTurtleCommand");
		commands.put("forward", "commands.turtleCommands.ForwardTurtleCommand");
		commands.put("bk", "commands.turtleCommands.BackTurtleCommand");
		commands.put("back", "commands.turtleCommands.BackTurtleCommand");
		commands.put("lt", "commands.turtleCommands.LeftTurtleCommand");
		commands.put("left", "commands.turtleCommands.LeftTurtleCommand");
		commands.put("rt", "commands.turtleCommands.RightTurtleCommand");
		commands.put("right", "commands.turtleCommands.RightTurtleCommand");
		commands.put("seth", "commands.turtleCommands.SetHeadingTurtleCommand");
		commands.put("setheading",
				"commands.turtleCommands.SetHeadingTurtleCommand");
		commands.put("goto", "commands.turtleCommands.GotoTurtleCommand");
		commands.put("setxy", "commands.turtleCommands.GotoTurtleCommand");
		commands.put("pd", "commands.turtleCommands.PenDownTurtleCommand");
		commands.put("pendown", "commands.turtleCommands.PenDownTurtleCommand");
		commands.put("pu", "commands.turtleCommands.PenUpTurtleCommand");
		commands.put("penup", "commands.turtleCommands.PenUpTurtleCommand");
		commands.put("st", "commands.turtleCommands.ShowTurtleTurtleCommand");
		commands.put("showturtle",
				"commands.turtleCommands.ShowTurtleTurtleCommand");
		commands.put("ht", "commands.turtleCommands.HideTurtleTurtleCommand");
		commands.put("hideturtle",
				"commands.turtleCommands.HideTurtleTurtleCommand");
		commands.put("home", "commands.turtleCommands.HomeTurtleCommand");
		commands.put("cs", "commands.turtleCommands.ClearScreenTurtleCommand");
		commands.put("clearscreen",
				"commands.turtleCommands.ClearScreenTurtleCommand");
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
