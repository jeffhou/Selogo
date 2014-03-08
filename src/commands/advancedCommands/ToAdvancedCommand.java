package commands.advancedCommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import backend.Interpreter;
import commands.AdvancedCommand;
import commands.UserCommand;

public class ToAdvancedCommand extends AdvancedCommand{

	public ToAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws Exception {
		try {
			Interpreter interpreter = (Interpreter) o;
			String commandName = interpreter.readNextCommand();
			ArrayList<String> parameters = interpreter.readBrackets();
			ArrayList<String> commandsList = interpreter.readBrackets();
			return interpreter.addUserCommand(commandName, new UserCommand(parameters,commandsList));
		}
		catch(Exception e){
			return 0;
		}
	}

}
