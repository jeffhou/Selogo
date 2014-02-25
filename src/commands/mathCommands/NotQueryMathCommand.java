package commands.mathCommands;

public class NotQueryMathCommand extends MathCommand {

	public NotQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) + parameters.get(1);
	}

}
