package slogo_team12;

import java.util.ArrayList;

import exceptions.NotEnoughParametersException;

public abstract class Command {
	protected final int NUM_OF_PARAMETERS;
	protected ArrayList<Double> parameters;
	protected final String COMMAND_TYPE;
	Command(int numberOfParameters, String commandType){
		NUM_OF_PARAMETERS = numberOfParameters;
		COMMAND_TYPE = commandType;
	}
	public void loadParameters(ArrayList<Double> parameters) throws NotEnoughParametersException{
		if(NUM_OF_PARAMETERS == parameters.size()){
			this.parameters = parameters;
		}else{
			throw new NotEnoughParametersException();
		}
	};
	public abstract double execute(Turtle t);
}
