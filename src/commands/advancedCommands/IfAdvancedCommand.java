package commands.advancedCommands;

import backend.Interpreter;
import backend.Turtle;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;

public class IfAdvancedCommand extends AdvancedCommand {

	public IfAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException {
		Interpreter interpreter = (Interpreter) o;
		Turtle turtleBefore = interpreter.engine.turtle.clone();
		Double ret = 0.0;
		for (int i = 0; i < 1; i++) {
			if (!interpreter.listOfWords.remove(0).equals("[")) {
				throw new InvalidSyntaxException();
			}
			while (interpreter.listOfWords.size() > 0) {
				try {
					ret = interpreter.evaluateCommand(interpreter.listOfWords);
				} catch (EndOfStackException e) {
					continue;
				}
			}
		}
		if (parameters.get(0) == 0) {
			interpreter.engine.turtle = turtleBefore;
		}
		return ret;
	}

}
