package commands.mathCommands;

import commands.MathCommand;

public class LessQueryMathCommand extends MathCommand {

	public LessQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) < parameters.get(1) ? 1 : 0;
	}

}
