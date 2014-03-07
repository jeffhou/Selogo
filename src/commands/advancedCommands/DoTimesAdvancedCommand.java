package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;

public class DoTimesAdvancedCommand extends AdvancedCommand {

	public DoTimesAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws Exception {
		Interpreter interpreter = (Interpreter) o;
		String[] variableAndLimit = interpreter.readBrackets().split(" ");
		String variable = variableAndLimit[0].substring(1);
		double oldValue = interpreter.getVariable(variable);
		try {
			int limit = Integer.parseInt(variableAndLimit[1]);
			String commandList = interpreter.readBrackets();
			for(int i = 0; i < limit; i++) {
				interpreter.interpret("set :" + variable + " " + i);
				interpreter.interpret(commandList);
			}
			interpreter.interpret("set :" + variable + " " + oldValue);
		}
		catch (Exception e) {
			throw new InvalidSyntaxException();
		}
		return 0;
	}

}
