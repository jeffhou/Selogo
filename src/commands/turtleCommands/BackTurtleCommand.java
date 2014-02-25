package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

public class BackTurtleCommand extends TurtleCommand {

	public BackTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.move(new Tuple(0, -parameters.get(0)));
	}

}
