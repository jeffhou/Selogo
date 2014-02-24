package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

public class GotoTurtleCommand extends TurtleCommand {

	public GotoTurtleCommand() {
		super(2);
	}

	@Override
	public double execute(Turtle t) {
		return t.moveTo(new Tuple(parameters.get(0), parameters.get(1)));
	}

}
