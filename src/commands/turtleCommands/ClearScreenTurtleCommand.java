package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

public class ClearScreenTurtleCommand extends TurtleCommand {

	public ClearScreenTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		return t.clear();
	}

}
