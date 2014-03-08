package commands.guiCommands;

import backend.WorldsCollection;
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
		Double newColor = parameters.get(0);
		//WorldsCollection.getInstance().getCurrentWorld().setPenColor(color);
		return 0;
	}

}
