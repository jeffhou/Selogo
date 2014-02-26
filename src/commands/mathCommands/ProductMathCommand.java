package commands.mathCommands;

import commands.MathCommand;

public class ProductMathCommand extends MathCommand {

	public ProductMathCommand() {
		super(2);
	}

	@Override
	public double execute(Object o) {
		return parameters.get(0) * parameters.get(1);
	}

}
