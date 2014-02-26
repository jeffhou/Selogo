package commands.mathCommands;

import commands.MathCommand;

public class SinMathCommand extends MathCommand {
	public SinMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		// TODO Auto-generated method stub

		return Math.sin(Math.toRadians(parameters.get(0)));
	}

}
