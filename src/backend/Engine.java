package backend;

import commands.Command;
import exceptions.InvalidCommandException;

public class Engine {
	public Turtle turtle;

	Engine() {
		turtle = new Turtle();
	}

	public double obey(Command newCommand) throws InvalidCommandException {
		if (newCommand.COMMAND_TYPE.equals("turtle")) {
			return newCommand.execute(turtle);
		} else if (newCommand.COMMAND_TYPE.equals("math")) {
			return newCommand.execute(null);
		}
		throw new InvalidCommandException();
	}

	public Turtle getTurtle() {
		return turtle;
	}

}
