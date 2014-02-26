package commands.mathCommands;

public class PowMathCommand extends MathCommand {

	public PowMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		double base = parameters.get(0);
		double exponent = parameters.get(1);
		return Math.pow(base, exponent);

	}

}
