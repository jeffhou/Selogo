package commands.turtleCommands;

import backend.Tuple;
import backend.WorldModel; import backend.WorldsCollection;
import commands.TurtleCommand;

public class BackTurtleCommand extends TurtleCommand {

	public BackTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		return t.move(new Tuple(0, -parameters.get(0)));
	}

}
