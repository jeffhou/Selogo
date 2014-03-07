package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import commands.AdvancedCommand;

public class IfElseAdvancedCommand extends AdvancedCommand {

	public IfElseAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws Exception {
		boolean isTrue = parameters.get(0).intValue() != 0;
		Interpreter interpreter = (Interpreter) o;
		ArrayList<String> trueCommands = interpreter.readBrackets();
		ArrayList<String> falseCommands = interpreter.readBrackets();
		if (isTrue) {
			interpreter.addCommandToQueue(trueCommands);
		} else {
			interpreter.addCommandToQueue(falseCommands);
		}
		return 0;
	}

}
