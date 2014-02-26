package commands.mathCommands;

public class CosMathCommand extends MathCommand {
	
	public CosMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		
		double expr = parameters.get(0);
		return Math.cos(expr);
		
	}

}
