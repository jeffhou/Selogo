package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class PenUpTurtleCommand extends TurtleCommand {

	public PenUpTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		t.setPen(false);
		return 0;
	}

}
