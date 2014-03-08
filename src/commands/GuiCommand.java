package commands;

import exceptions.EndOfStackException;
import exceptions.InvalidSyntaxException;
import exceptions.SlogoException;

public abstract class GuiCommand extends Command {
	
	/**
	 * @param numberOfParameters
	 * Creates GuiCommand
	 */
	public GuiCommand(int numberOfParameters) {
		super(numberOfParameters, "gui");
	}



}
