package commands.turtleCommands;

import backend.Turtle;

import commands.TurtleCommand;

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
