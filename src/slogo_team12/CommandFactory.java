package slogo_team12;

import java.util.HashMap;

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
	HashMap<String, Integer> commandParameters = new HashMap<String, Integer>();
	public CommandFactory(Interpreter interpreter, Engine engine){
		this.interpreter = interpreter;
		this.engine = engine;
		commandParameters.put("fd", 1);
		commandParameters.put("bk", 1);
		commandParameters.put("lt", 1);
		commandParameters.put("rt", 1);
	}

	public Command createCommand(String firstWord) 
			throws InvalidCommandStringException {
		if(firstWord.equals("fd")){
			return new ForwardTurtleCommand();
		}
		if(firstWord.equals("bk")){
			return new BackwardTurtleCommand();
		}
		if(firstWord.equals("lt")){
			return new LeftTurtleCommand();
		}
		if(firstWord.equals("rt")){
			return new RightTurtleCommand();
		}
		throw new InvalidCommandStringException();
	}
	
}
