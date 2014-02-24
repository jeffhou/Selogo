package commands;

import backend.Turtle;

public class PenUpTurtleCommand extends TurtleCommand {

	PenUpTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setPen(false);
		return 0;
	}

}
