package commands.turtleCommands;

import backend.Turtle;

import commands.TurtleCommand;

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
