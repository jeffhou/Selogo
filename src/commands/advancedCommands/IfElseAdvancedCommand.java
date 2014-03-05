package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class IfElseAdvancedCommand extends AdvancedCommand {

	public IfElseAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, SlogoException, EndOfStackException {
		boolean isTrue = parameters.get(0).intValue() != 0;
		Interpreter interpreter = (Interpreter) o;
		String trueCommands = interpreter.readBrackets();
		String falseCommands = interpreter.readBrackets();
		if(isTrue) {
			interpreter.interpret(trueCommands);
		}
		else {
			interpreter.interpret(falseCommands);
		}
		return 0;
	}

}
