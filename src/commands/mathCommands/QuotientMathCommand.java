package commands.mathCommands;

public class QuotientMathCommand extends MathCommand {


	public QuotientMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) / parameters.get(1);
	}

}
