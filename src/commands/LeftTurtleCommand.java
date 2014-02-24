package commands;

import slogo_team12.Turtle;

public class LeftTurtleCommand extends TurtleCommand {

	LeftTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return -t.turnClockwise(-parameters.get(0));
	}

}
