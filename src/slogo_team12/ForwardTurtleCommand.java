package slogo_team12;

public class ForwardTurtleCommand extends Command {
	
	ForwardTurtleCommand(){
		super(1);
	}
	
	@Override
	public double execute(Turtle t) {
		return t.move(new Tuple(0, parameters.get(0)));
	}

}
