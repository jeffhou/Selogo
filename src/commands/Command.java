package commands;

import java.util.ArrayList;

import exceptions.NotEnoughParametersException;

public abstract class Command {
	public final int NUM_OF_PARAMETERS;
	protected ArrayList<Double> parameters;
	public final String COMMAND_TYPE;

	protected Command(int numberOfParameters, String commandType) {
		NUM_OF_PARAMETERS = numberOfParameters;
		COMMAND_TYPE = commandType;
	}

	public void loadParameters(ArrayList<Double> parameters)
			throws NotEnoughParametersException {
		if (NUM_OF_PARAMETERS == parameters.size()) {
			this.parameters = parameters;
		} else {
			throw new NotEnoughParametersException();
		}
	};
	public abstract double execute(Object o);
}
