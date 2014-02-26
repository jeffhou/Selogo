package commands.mathCommands;

public class ArcTanMathCommand extends MathCommand {

	public ArcTanMathCommand() {
		super(1);
	}
	
	@Override
	public double execute(Object o) {
		double expr = parameters.get(0);
		return Math.atan(expr);
	}

}
