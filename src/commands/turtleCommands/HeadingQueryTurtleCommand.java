package commands.turtleCommands;

import backend.Turtle;

public class HeadingQueryTurtleCommand extends TurtleCommand {

	public HeadingQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.getHeading();
	}

}
