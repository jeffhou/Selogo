package commands.turtleCommands;

import commands.Command;

public abstract class TurtleCommand extends Command {
	
	public TurtleCommand(int numberOfParameters) {
		super(numberOfParameters, "turtle");
	}
	
}
