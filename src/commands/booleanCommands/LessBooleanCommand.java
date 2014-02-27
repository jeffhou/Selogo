package commands.booleanCommands;



public class LessBooleanCommand extends BooleanCommand {

	public LessBooleanCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		double expr1 = parameters.get(0);
		double expr2 = parameters.get(1);
		// convert comparison to a double
		return booltoDouble(expr1 < expr2);
	}

}
