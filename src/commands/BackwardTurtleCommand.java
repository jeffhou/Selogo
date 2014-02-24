package commands;

import slogo_team12.Tuple;
import slogo_team12.Turtle;

public class BackwardTurtleCommand extends TurtleCommand {

	BackwardTurtleCommand() {
		super(1);
	}

	@Override
	public double execute(Turtle t) {
		return t.move(new Tuple(0, -parameters.get(0)));
	}

}
