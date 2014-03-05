package backend;

import commands.Command;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class CommandInvoker {
	Interpreter interpreter;
	private Turtle turtle;

	CommandInvoker(Interpreter interpreter) {
		turtle = new Turtle();
		this.interpreter = interpreter;
	}

	public Turtle getTurtle() {
		return turtle;
	}

	public double obey(Command newCommand) throws InvalidSyntaxException, InstantiationException,
	IllegalAccessException, ClassNotFoundException,
	EndOfStackException, SlogoException {

		if (newCommand.COMMAND_TYPE.equals("turtle")) {
			return newCommand.execute(turtle);
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
