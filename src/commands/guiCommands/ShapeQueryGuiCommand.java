package commands.guiCommands;

import commands.GuiCommand;
import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public class ShapeQueryGuiCommand extends GuiCommand {
	
	public ShapeQueryGuiCommand() {
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
