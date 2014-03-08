package commands;

public abstract class MathCommand extends Command {

	/**
	 * @param numberOfParameters
	 * Creates the MathCommand
	 */
	public MathCommand(int numberOfParameters) {
		super(numberOfParameters, "math");
	}

}
