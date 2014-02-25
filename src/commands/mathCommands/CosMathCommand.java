package commands.mathCommands;

public class CosMathCommand extends MathCommand {

	public CosMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return Math.cos(Math.toRadians(parameters.get(0)));
	}

}
