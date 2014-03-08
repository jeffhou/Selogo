package commands;

public abstract class TurtleCommand extends Command {

	/**
	 * @param numberOfParameters
	 * Creates Turtle specific commands
	 */
	public TurtleCommand(int numberOfParameters) {
		super(numberOfParameters, "turtle");
	}

}
