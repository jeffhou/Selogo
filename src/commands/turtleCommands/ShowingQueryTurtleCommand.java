package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class ShowingQueryTurtleCommand extends TurtleCommand {

	public ShowingQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.getVisibility() ? 1 : 0;
	}

}
