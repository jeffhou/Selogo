package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

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
