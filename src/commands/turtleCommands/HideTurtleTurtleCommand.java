package commands.turtleCommands;

import java.util.ArrayList;

import backend.TurtleModel;
import backend.WorldModel; import backend.WorldsCollection;
import commands.TurtleCommand;

public class HideTurtleTurtleCommand extends TurtleCommand {

	public HideTurtleTurtleCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) {
		WorldModel t = WorldsCollection.getInstance().getCurrentWorld();
		ArrayList<TurtleModel> turtleList = t.getActiveTurtles();
		for(TurtleModel turtle : turtleList) {
			turtle.setShowing(false);
		}
		return 0;
	}
}
