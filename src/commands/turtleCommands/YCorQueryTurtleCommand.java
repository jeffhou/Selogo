package commands.turtleCommands;

import backend.Turtle;

public class YCorQueryTurtleCommand extends TurtleCommand {

	public YCorQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.getPosition().y;
	}

}
