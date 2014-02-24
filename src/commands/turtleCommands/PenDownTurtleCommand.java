package commands.turtleCommands;

import backend.Turtle;

public class PenDownTurtleCommand extends TurtleCommand {

	public PenDownTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setPen(true);
		return 1;
	}

}
