package slogo_team12;

public class LeftTurtleCommand extends TurtleCommand {

	LeftTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return t.setHeading(-parameters.get(0));
	}

}
