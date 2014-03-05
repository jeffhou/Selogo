package commands;

import java.util.ArrayList;



import exceptions.EndOfStackException;
import exceptions.InvalidCommandException;
import exceptions.InvalidCommandStringException;
import exceptions.InvalidSyntaxException;
import exceptions.InvalidWordException;
import exceptions.NotEnoughParametersException;
import exceptions.SlogoException;


public abstract class Command {
	public final String COMMAND_TYPE;
	public final int NUM_OF_PARAMETERS;
	protected ArrayList<Double> parameters;

	protected Command(int numberOfParameters, String commandType) {
		NUM_OF_PARAMETERS = numberOfParameters;
		COMMAND_TYPE = commandType;
	}

	public abstract double execute(Object o) throws InvalidSyntaxException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, SlogoException, EndOfStackException;;


	public void loadParameters(ArrayList<Double> parameters)
			throws NotEnoughParametersException {
		if (NUM_OF_PARAMETERS == parameters.size()) {
			this.parameters = parameters;
		} else {
			throw new NotEnoughParametersException();
		}
	}
	
	//public abstract Command createCommand();
}
