package commands.mathCommands;

import commands.MathCommand;

public class GreaterQueryMathCommand extends MathCommand {

	public GreaterQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) > parameters.get(1) ? 1 : 0;
	}

}
