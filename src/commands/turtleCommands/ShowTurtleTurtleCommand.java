package commands.turtleCommands;

import backend.Turtle;

public class ShowTurtleTurtleCommand extends TurtleCommand {

	public ShowTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		t.setVisibility(true);
		return 1;
	}

}
