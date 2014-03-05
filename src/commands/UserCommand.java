package commands;

import java.util.Arrays;

public class UserCommand {
	public String[] parameters;
	public String commands;
	
	public UserCommand(String parameterString, String commandString) {
		commands = commandString;
		parameters = parameterString.split(" ");
	}
	
	public String toString() {
		return "parameters: " + Arrays.toString(parameters) + "\n" + "commands: " + commands;
	}
}
