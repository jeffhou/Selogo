package commands.turtleCommands;

import backend.Turtle;

public class LeftTurtleCommand extends TurtleCommand {

	public LeftTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return -t.turnClockwise(-parameters.get(0));
	}

}
