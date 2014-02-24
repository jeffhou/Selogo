package commands;

import java.util.HashMap;

import slogo_team12.Engine;
import slogo_team12.Interpreter;
import exceptions.InvalidCommandStringException;

public class CommandFactory {
	
	final static String[] TURTLE_COMMANDS = {
		"forward",
		"fd",
		"back",
		"bk",
		"left",
		"lf",
		"right",
		"rt",
		"setheading",
		"seth",
		"towards",
		"setxy",
		"goto",
		"pendown",
		"pd",
		"penup",
		"pu",
		"showturtle",
		"st",
		"hideturtle",
		"ht",
		"home",
		"clearscreen",
		"cs",
		"xcor",
		"ycor",
		"heading",
		"pendown?",
		"pendownp",
		"showing?",
		"showingp"
	};
	Interpreter interpreter;
	Engine engine;
	public HashMap<String, Integer> commandParameters = new HashMap<String, Integer>();
	public HashMap<String, String> commandClasses = new HashMap<String, String>();
	public CommandFactory(Interpreter interpreter, Engine engine){
		this.interpreter = interpreter;
		this.engine = engine;
		/**
		 * TODO: this is duplicate code. Create a properties file
		 * or an XML file and make the factory read it instead.
		 */
		commandParameters.put("fd", 1);
		commandClasses.put("fd", "commands.ForwardTurtleCommand");
		commandParameters.put("bk", 1);
		commandClasses.put("bk", "commands.BackTurtleCommand");
		commandParameters.put("lt", 1);
		commandClasses.put("lt", "commands.LeftTurtleCommand");
		commandParameters.put("rt", 1);
		commandClasses.put("rt", "commands.RightTurtleCommand");
		commandParameters.put("seth", 1);
		commandClasses.put("seth", "commands.SetHeadingTurtleCommand");
		commandParameters.put("goto", 2);
		commandClasses.put("goto", "commands.GotoTurtleCommand");
	}

	public Command createCommand(String firstWord) 
			throws InvalidCommandStringException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(commandParameters.containsKey(firstWord)){
			return (Command) Class.forName(commandClasses.get(firstWord)).newInstance();
		}
		throw new InvalidCommandStringException();
	}
	
}
