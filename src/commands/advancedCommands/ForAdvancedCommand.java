package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;

public class ForAdvancedCommand extends AdvancedCommand {

	public ForAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws Exception {
		Interpreter interpreter = (Interpreter) o;
		String[] variableAndLimit = interpreter.readBrackets().split(" ");
		String variable = variableAndLimit[0].substring(1);
		double oldValue = interpreter.getVariable(variable);
		try{
			int start = Integer.parseInt(variableAndLimit[1]);
			int end = Integer.parseInt(variableAndLimit[2]);
			int increment = Integer.parseInt(variableAndLimit[3]);
			String commandList = interpreter.readBrackets();
			for(int i = start; i < end; i+=increment) {
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
