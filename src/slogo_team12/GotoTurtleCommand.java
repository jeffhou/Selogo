package slogo_team12;

public class GotoTurtleCommand extends TurtleCommand {

	GotoTurtleCommand() {
		super(2);
	}

	@Override
	public double execute(Turtle t) {
		return t.moveTo(new Tuple(parameters.get(0), parameters.get(1)));
	}

}
