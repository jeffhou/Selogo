package commands.turtleCommands;

import backend.Turtle;

public class HomeTurtleCommand extends TurtleCommand {

	public HomeTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		return t.home();
	}

}
