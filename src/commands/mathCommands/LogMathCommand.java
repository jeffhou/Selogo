package commands.mathCommands;

public class LogMathCommand extends MathCommand {
	
	public LogMathCommand(){
		super(1);
	}
	@Override
	public double execute(Object o) {
		double expr = parameters.get(0);
		return Math.log(expr);
	}

}
