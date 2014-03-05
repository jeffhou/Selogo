package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class DoTimesAdvancedCommand extends AdvancedCommand {

	public DoTimesAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SlogoException, EndOfStackException {
		Interpreter interpreter = (Interpreter) o;
		String[] variableAndLimit = interpreter.readBrackets().split(" ");
		
		String variable = variableAndLimit[0].substring(1);
		int limit = Integer.parseInt(variableAndLimit[1]);
		double oldValue = interpreter.getVariable(variable);
		String commandList = interpreter.readBrackets();
		for(int i = 0; i < limit; i++) {
			interpreter.interpret("set :" + variable + " " + i);
			interpreter.interpret(commandList);
		}
		interpreter.interpret("set :" + variable + " " + oldValue);
		return 0;
	}

}
