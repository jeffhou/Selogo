package commands;

import backend.Interpreter;
import exceptions.InvalidCommandException;

public class CommandInvoker {
	Interpreter interpreter;

	public CommandInvoker(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	public double obey(Command newCommand) throws Exception {

		if (newCommand.COMMAND_TYPE.equals("turtle")) {
			return newCommand.execute(null);
		} else if (newCommand.COMMAND_TYPE.equals("math")) {
			return newCommand.execute(null);
		} else if (newCommand.COMMAND_TYPE.equals("boolean")) {
			return newCommand.execute(null);
		} else if (newCommand.COMMAND_TYPE.equals("advanced")) {
			return newCommand.execute(interpreter);
		}
		throw new InvalidCommandException();
	}

}
