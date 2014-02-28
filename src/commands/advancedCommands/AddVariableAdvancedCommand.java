package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;

public class AddVariableAdvancedCommand extends AdvancedCommand {

	public AddVariableAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, InvalidCommandStringException,
	InvalidWordException, NotEnoughParametersException,
	InvalidCommandException, EndOfStackException {
		Interpreter interpreter = (Interpreter) o;
		Double ret = interpreter.addVariable();
		return ret;
	}

}
