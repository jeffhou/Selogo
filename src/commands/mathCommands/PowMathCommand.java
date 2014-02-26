package commands.mathCommands;

import commands.MathCommand;

public class PowMathCommand extends MathCommand {

	public PowMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return Math.pow(parameters.get(0), parameters.get(1));
	}

}
