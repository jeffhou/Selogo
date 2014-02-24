package commands.turtleCommands;

import commands.Command;

public abstract class TurtleCommand extends Command {
	TurtleCommand(int numberOfParameters) {
		super(numberOfParameters, "turtle");
	}
}
