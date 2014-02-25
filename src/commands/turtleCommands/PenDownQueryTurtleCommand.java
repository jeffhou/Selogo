package commands.turtleCommands;

import backend.Turtle;

public class PenDownQueryTurtleCommand extends TurtleCommand {

	public PenDownQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.getPenState() ? 1 : 0;
	}

}
