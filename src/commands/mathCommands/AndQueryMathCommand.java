package commands.mathCommands;

public class AndQueryMathCommand extends MathCommand {

	public AndQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) != 0 && parameters.get(1) != 0 ? 1 : 0;
	}

}
