package slogo_team12;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandFactory {
	Interpreter interpreter;
	HashMap<String, Integer> commandParameters = new HashMap<String, Integer>();
	public CommandFactory(Interpreter interpreter){
		this.interpreter = interpreter;
		commandParameters.put("fd", 1);
	}

	public Command createCommand(String firstWord) throws InvalidCommandStringException {
		if(firstWord.equals("fd")){
			return new ForwardTurtleCommand();
		}
		throw new InvalidCommandStringException();
	}
	public class InvalidCommandStringException extends Exception{}
}
