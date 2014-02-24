package commands;

import backend.Turtle;

public class PenDownTurtleCommand extends TurtleCommand {

	PenDownTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setPen(true);
		return 1;
	}

}
