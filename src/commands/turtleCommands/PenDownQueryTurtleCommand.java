package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class PenDownQueryTurtleCommand extends TurtleCommand {

	public PenDownQueryTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		return t.getPenState() ? 1 : 0;
	}

}
