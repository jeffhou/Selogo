package slogo_team12;

import java.util.ArrayList;

public abstract class Command {
	protected final int NUM_OF_PARAMETERS;
	protected ArrayList<Double> parameters;
	Command(int numberOfParameters){
		NUM_OF_PARAMETERS = numberOfParameters;
	}
	public void loadParameters(ArrayList<Double> parameters){
		this.parameters = parameters;
	};
	public abstract double execute(Turtle t);
}
