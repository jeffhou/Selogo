package commands.mathCommands;

public class LogMathCommand extends MathCommand {

	public LogMathCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) {
		return Math.log(parameters.get(0));
	}

}
