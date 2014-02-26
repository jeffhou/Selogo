package commands.mathCommands;

public class EqualQueryMathCommand extends MathCommand {

	public EqualQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) == parameters.get(1) ? 1 : 0;
	}

}
