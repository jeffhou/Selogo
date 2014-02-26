package commands.mathCommands;

public class DifferenceMathCommand extends MathCommand {
	public DifferenceMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) - parameters.get(1);
	}

}
