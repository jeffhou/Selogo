package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class IfAdvancedCommand extends AdvancedCommand {

	public IfAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws Exception {
		boolean isTrue = parameters.get(0).intValue() != 0;
		Interpreter interpreter = (Interpreter) o;
		String bracketContents = interpreter.readBrackets();
		if(isTrue) {
			interpreter.interpret(bracketContents);
		}
		return 0;
	}
}
