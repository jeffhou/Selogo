package commands;

public abstract class TurtleCommand extends Command {

	public TurtleCommand(int numberOfParameters) {
		super(numberOfParameters, "turtle");
	}

}
