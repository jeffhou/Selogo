package commands.advancedCommands;

import java.util.ArrayList;
import backend.Interpreter;
import backend.StringOps;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;
import exceptions.NotEnoughParametersException;
import exceptions.SlogoException;


public class RepeatAdvancedCommand extends AdvancedCommand {

	public RepeatAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, SlogoException, NotEnoughParametersException
	{
		int multiple = parameters.get(0).intValue();
		Interpreter interpreter = (Interpreter) o;
		String bracketContents = interpreter.readBrackets();
	
		for(int i = 0; i < multiple; i++) {
			interpreter.interpret(bracketContents);
		}
		return 0;
	}
}
