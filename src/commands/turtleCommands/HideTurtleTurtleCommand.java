package commands.turtleCommands;

import backend.Turtle;

public class HideTurtleTurtleCommand extends TurtleCommand {

	public HideTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setVisibility(false);
		return 0;
	}

}
