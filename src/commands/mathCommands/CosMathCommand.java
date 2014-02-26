package commands.mathCommands;

import commands.MathCommand;

public class CosMathCommand extends MathCommand {

	public CosMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		
		double degrees = parameters.get(0);
		return Math.cos(Math.toRadians(degrees));
		
	}

}
