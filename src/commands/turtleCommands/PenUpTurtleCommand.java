package commands.turtleCommands;

import backend.Turtle;

public class PenUpTurtleCommand extends TurtleCommand {

	public PenUpTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setPen(false);
		return 0;
	}

}
