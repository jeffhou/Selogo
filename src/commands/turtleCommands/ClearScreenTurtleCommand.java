package commands.turtleCommands;

import backend.Turtle;

import commands.TurtleCommand;

public class ClearScreenTurtleCommand extends TurtleCommand {

	public ClearScreenTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.clear();
	}

}
