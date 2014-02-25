package commands.mathCommands;

public class SinMathCommand extends MathCommand {

	public SinMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return Math.sin(Math.toRadians(parameters.get(0)));
	}

}
