package backend;

import commands.Command;

import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;

public class Engine {
	Interpreter interpreter;
	public Turtle turtle;
	private Turtle turtleState;

	Engine(Interpreter interpreter) {
		turtle = new Turtle();
		this.interpreter = interpreter;
	}

	public Turtle getTurtle() {
		return turtle;
	}

	public double obey(Command newCommand) throws InvalidCommandException,
			InvalidSyntaxException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvalidCommandStringException, InvalidWordException,
			NotEnoughParametersException, EndOfStackException {
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

	public void restoreTurtleState() {
		turtle = turtleState;
	}

	public void saveTurtleState() {
		turtleState = turtle.clone();
	}

}
