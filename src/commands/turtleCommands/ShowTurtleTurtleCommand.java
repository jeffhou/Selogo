package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class ShowTurtleTurtleCommand extends TurtleCommand {

	public ShowTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		t.setVisibility(true);
		return 1;
	}

}
