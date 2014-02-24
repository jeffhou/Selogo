package commands;

public abstract class TurtleCommand extends Command {
	TurtleCommand(int numberOfParameters) {
		super(numberOfParameters, "turtle");
	}
}
