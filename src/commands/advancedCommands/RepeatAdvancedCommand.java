package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import backend.StringOps;

import commands.AdvancedCommand;

import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.VariableNotFoundException;

public class RepeatAdvancedCommand extends AdvancedCommand {

	public RepeatAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException, VariableNotFoundException {
		int multiple = parameters.get(0).intValue();
		Interpreter interpreter = (Interpreter) o;
		interpreter.engine.saveTurtleState();

		Double ret;
		ArrayList<String> newList = StringOps.deepCopy(interpreter.listOfWords);

		do {
			interpreter.listOfWords = StringOps.deepCopy(newList);
			ret = interpreter.readBrackets();
			multiple--;
		} while (multiple > 0);

		if (parameters.get(0) < 1) {
			interpreter.engine.restoreTurtleState();
		}
		return ret;
	}

}
