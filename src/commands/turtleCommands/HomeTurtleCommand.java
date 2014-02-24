package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

public class HomeTurtleCommand extends TurtleCommand {

	HomeTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Turtle t) {
		return t.moveTo(new Tuple());
	}

}
