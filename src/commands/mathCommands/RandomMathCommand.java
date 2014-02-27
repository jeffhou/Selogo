package commands.mathCommands;

import java.util.Random;

import commands.MathCommand;

public class RandomMathCommand extends MathCommand {

	public RandomMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {

		Random generator = new Random();
		double max = parameters.get(0);
		if(max < 0) {
			return 0;
		}
		double randomDouble = generator.nextDouble() * max;
		return randomDouble;

	}

}
