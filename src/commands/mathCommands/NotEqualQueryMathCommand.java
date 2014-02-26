package commands.mathCommands;

public class NotEqualQueryMathCommand extends MathCommand {

	public NotEqualQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) != parameters.get(1) ? 1 : 0;
	}

}
