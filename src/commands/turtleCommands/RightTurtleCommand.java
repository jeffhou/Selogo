package commands.turtleCommands;

import backend.Turtle;

public class RightTurtleCommand extends TurtleCommand {

	public RightTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.turnClockwise(parameters.get(0));
	}

}
