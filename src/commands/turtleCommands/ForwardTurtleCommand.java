package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

import commands.TurtleCommand;

public class ForwardTurtleCommand extends TurtleCommand {

	public ForwardTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.move(new Tuple(0, parameters.get(0)));
	}

}
