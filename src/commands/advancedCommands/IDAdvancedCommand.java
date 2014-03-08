package commands.advancedCommands;

import backend.Interpreter;
import commands.AdvancedCommand;
import commands.TurtleCommand;

public class IDAdvancedCommand extends AdvancedCommand {

	public IDAdvancedCommand() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute(Object o) throws Exception {
		Interpreter interpreter = (Interpreter) o;
		return interpreter.getCurrentWorld().getTurtleID();
	}

}
