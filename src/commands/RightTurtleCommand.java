package commands;

import backend.Turtle;

public class RightTurtleCommand extends TurtleCommand {

	RightTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return t.turnClockwise(parameters.get(0));
	}

}
