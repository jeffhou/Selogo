package commands.turtleCommands;

import backend.Tuple;
import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class GotoTurtleCommand extends TurtleCommand {

	public GotoTurtleCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		return t.moveTo(new Tuple(parameters.get(0), parameters.get(1)));
	}

}
