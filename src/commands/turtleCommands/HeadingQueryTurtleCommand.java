package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class HeadingQueryTurtleCommand extends TurtleCommand {

	public HeadingQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		return t.getTurtle().getHeading();
	}

}
