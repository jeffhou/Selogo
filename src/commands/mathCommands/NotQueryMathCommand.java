package commands.mathCommands;

import commands.MathCommand;

public class NotQueryMathCommand extends MathCommand {

	public NotQueryMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) == 0 ? 1 : 0;
	}

}
