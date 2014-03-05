package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class ShowTurtleTurtleCommand extends TurtleCommand {

	public ShowTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		t.getTurtle().setShowing(true);
		return 1;
	}

}
