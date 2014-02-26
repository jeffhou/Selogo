package commands;

public abstract class MathCommand extends Command {

	public MathCommand(int numberOfParameters) {
		super(numberOfParameters, "math");
	}

}
