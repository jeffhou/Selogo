package commands.mathCommands;

public class MinusMathCommand extends MathCommand {
	public MinusMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return -1 * parameters.get(0);
	}

}
