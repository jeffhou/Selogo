package slogo_team12;

public class SetHeadingTurtleCommand extends TurtleCommand {

	SetHeadingTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return t.setHeadingTo(parameters.get(0));
	}

}
