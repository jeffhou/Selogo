package commands;

import java.util.ArrayList;
import java.util.Arrays;

public class UserCommand {
	public ArrayList<String> parameters;
	public ArrayList<String> commands;
	
	public UserCommand() {}
	
	/**
	 * @param parameterString
	 * @param commandString
	 * Creates user defined commands
	 */
	public UserCommand(ArrayList<String> parameterString, ArrayList<String> commandString) {
		commands = commandString;
		parameters = parameterString;
	}

	public String toString() {
		return "parameters: " + parameters.toString() + "\n" + "commands: " + commands.toString();
	}
}