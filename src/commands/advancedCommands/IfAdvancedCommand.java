package commands.advancedCommands;

import backend.Interpreter;

import commands.AdvancedCommand;

import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class IfAdvancedCommand extends AdvancedCommand {

	public IfAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException,SlogoException {
		Interpreter interpreter = (Interpreter) o;
		interpreter.engine.saveTurtleState();

		Double ret = interpreter.readBrackets();

		if (parameters.get(0) == 0) {
			interpreter.engine.restoreTurtleState();
		}
		return ret;
	}

}
