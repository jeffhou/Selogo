package commands.booleanCommands;

public class NotBooleanCommand extends BooleanCommand {
	
	public NotBooleanCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		double test1 = parameters.get(0);
	
		boolean result = (test1 > 0);
		
		return booltoDouble(result);
	}

}
