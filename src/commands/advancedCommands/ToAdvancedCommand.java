package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import commands.AdvancedCommand;
import commands.UserCommand;
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
		ArrayList<String> parameters = interpreter.readBrackets();
		ArrayList<String> commandsList = interpreter.readBrackets();

		try {
			return interpreter.addUserCommand(commandName, new UserCommand(interpreter.readBrackets(), interpreter.readBrackets()));
		}
		catch(Exception e){
			return 0;
		}
	}

}
