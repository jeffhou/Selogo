package commands.turtleCommands;

import backend.Turtle;

import commands.TurtleCommand;

public class XCorQueryTurtleCommand extends TurtleCommand {

	public XCorQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.getPosition().x;
	}

}
