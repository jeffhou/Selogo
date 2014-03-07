package commands.guiCommands;

import commands.GuiCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class SetPenColorGuiCommand extends GuiCommand {
	
	public SetPenColorGuiCommand() {
		super(1);
	}

	@Override
	public double execute(Object o) throws InvalidSyntaxException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SlogoException, EndOfStackException {
		// TODO Auto-generated method stub
		return 0;
	}

}
