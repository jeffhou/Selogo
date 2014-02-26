package commands.turtleCommands;

import commands.TurtleCommand;

import backend.Turtle;

public class HomeTurtleCommand extends TurtleCommand {

	public HomeTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		Turtle t = (Turtle) o;
		return t.home();
	}

}
