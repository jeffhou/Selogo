package commands.advancedCommands;

import java.util.ArrayList;

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
		ArrayList<String> bracketContents = interpreter.readBrackets();
		System.out.println(bracketContents.toString());
		if(isTrue) {
			interpreter.addCommandToQueue(bracketContents);
		}
		return 0;
	}
}
