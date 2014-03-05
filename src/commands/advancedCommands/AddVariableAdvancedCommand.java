package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.SlogoException;

public class AddVariableAdvancedCommand extends AdvancedCommand {

	public AddVariableAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, EndOfStackException, SlogoException {
		Interpreter interpreter = (Interpreter) o;
		String expression;
		String variableName = interpreter.readNextCommand();
		if (variableName.charAt(0) != ':') {
			throw new InvalidSyntaxException();
		}
		try {
			expression = interpreter.readNextCommand();
		}
		catch (Exception e) {
			throw new InvalidSyntaxException();
		}
		return interpreter.addVariable(variableName.substring(1), expression);
	}

}
