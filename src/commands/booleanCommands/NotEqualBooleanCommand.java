package commands.booleanCommands;



public class NotEqualBooleanCommand extends CheckEqualityBooleanCommand {

	public NotEqualBooleanCommand() {
		super();
	}

	@Override
	public double execute(Object O) {
		double expr1 = parameters.get(0);
		double expr2 = parameters.get(1);

		// convert comparison to a double
		return booltoDouble(expr1 != expr2);
	}
}
