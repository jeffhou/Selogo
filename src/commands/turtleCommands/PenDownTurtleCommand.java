package commands.turtleCommands;

import backend.Turtle;

import commands.TurtleCommand;

public class PenDownTurtleCommand extends TurtleCommand {

	public PenDownTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		t.setPen(true);
		return 1;
	}

}
