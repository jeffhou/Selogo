package commands.mathCommands;

import commands.MathCommand;

public class OrQueryMathCommand extends MathCommand {

	public OrQueryMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) != 0 || parameters.get(1) != 0 ? 1 : 0;
	}

}
