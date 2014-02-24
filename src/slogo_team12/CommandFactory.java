package slogo_team12;

import java.util.HashMap;

import exceptions.InvalidCommandStringException;

public class CommandFactory {
	Interpreter interpreter;
	Engine engine;
	HashMap<String, Integer> commandParameters = new HashMap<String, Integer>();
	public CommandFactory(Interpreter interpreter, Engine engine){
		this.interpreter = interpreter;
		this.engine = engine;
		commandParameters.put("fd", 1);
	}

	public Command createCommand(String firstWord) 
			throws InvalidCommandStringException {
		if(firstWord.equals("fd")){
			return new ForwardTurtleCommand();
		}
		throw new InvalidCommandStringException();
	}
	
}
