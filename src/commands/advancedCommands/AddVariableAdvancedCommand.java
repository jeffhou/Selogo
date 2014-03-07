package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;

public class AddVariableAdvancedCommand extends AdvancedCommand {

	public AddVariableAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws Exception {
		Interpreter interpreter = (Interpreter) o;
		String variableName = interpreter.readNextCommand();
		if (variableName.charAt(0) != ':') {
			throw new InvalidSyntaxException();
		}
		return interpreter.addVariable(variableName.substring(1));
	}

}
