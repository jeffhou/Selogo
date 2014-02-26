package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class HideTurtleTurtleCommand extends TurtleCommand {

	public HideTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		t.setVisibility(false);
		return 0;
	}

}
