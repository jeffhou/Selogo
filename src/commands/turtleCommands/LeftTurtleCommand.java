package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class LeftTurtleCommand extends TurtleCommand {

	public LeftTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return -t.turnClockwise(-parameters.get(0));
	}

}
