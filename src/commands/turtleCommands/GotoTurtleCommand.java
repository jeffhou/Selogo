package commands.turtleCommands;

import backend.Tuple;
import backend.Turtle;

import commands.TurtleCommand;

public class GotoTurtleCommand extends TurtleCommand {

	public GotoTurtleCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.moveTo(new Tuple(parameters.get(0), parameters.get(1)));
	}

}
