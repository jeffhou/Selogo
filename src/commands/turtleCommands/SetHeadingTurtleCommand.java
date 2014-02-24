package commands.turtleCommands;

import backend.Turtle;

public class SetHeadingTurtleCommand extends TurtleCommand {

	public SetHeadingTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return t.setHeadingTo(parameters.get(0));
	}

}
