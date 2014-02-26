package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import backend.StringOps;
import backend.Turtle;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;

public class ForAdvancedCommand extends AdvancedCommand {

	public ForAdvancedCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvalidCommandStringException,
			InvalidWordException, NotEnoughParametersException,
			InvalidCommandException {
		int multiple = parameters.get(0).intValue();
		Interpreter interpreter = (Interpreter) o;
		Turtle turtleBefore = interpreter.engine.turtle.clone();
		Double ret = 0.0;
		
		ArrayList<String> newList = StringOps.deepCopy(interpreter.listOfWords);;
		do{
			interpreter.listOfWords = StringOps.deepCopy(newList);
			for (int i = 0; i < 1; i++) {
				if (!interpreter.listOfWords.remove(0).equals("[")) {
					throw new InvalidSyntaxException();
				}
				while (interpreter.listOfWords.size() > 0) {
					try {
						ret = interpreter.evaluateCommand(interpreter.listOfWords);
					} catch (EndOfStackException e) {
						break;
					}
				}
			}
			multiple--;
		}while(multiple > 0);
		if (parameters.get(0) < 1) {
			interpreter.engine.turtle = turtleBefore;
		}
		return ret;
	}

}
