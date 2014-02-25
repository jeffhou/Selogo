package commands.mathCommands;

import java.util.Random;

public class RandomMathCommand extends MathCommand {

	public RandomMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		Random random = new Random();
		return random.nextInt(parameters.get(0).intValue());
	}

}
