package commands.mathCommands;

public class TanMathCommand extends MathCommand {

	public TanMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return Math.tan(Math.toRadians(parameters.get(0)));
	}

}
