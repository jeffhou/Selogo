package commands.advancedCommands;

import backend.Interpreter;
import backend.UserCommand;
import commands.AdvancedCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class ToAdvancedCommand extends AdvancedCommand {

	public ToAdvancedCommand() {
		super(0);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, SlogoException, EndOfStackException {
		Interpreter interpreter = (Interpreter) o;
		String commandName = interpreter.readNextCommand();
		try {
			return interpreter.addUserCommand(commandName, new UserCommand(interpreter.readBrackets(), interpreter.readBrackets()));
		}
		catch(Exception e){
			return 0;
		}
	}

}
