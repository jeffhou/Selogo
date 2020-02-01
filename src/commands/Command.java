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

  /**
   * @param numberOfParameters
   * @param commandType
   * Used to create basic commands
   */
  protected Command(int numberOfParameters, String commandType) {
    NUM_OF_PARAMETERS = numberOfParameters;
    COMMAND_TYPE = commandType;
  }

  /**
   * @param o
   * @return
   * @throws Exception
   * Executes the command passed to it
   */
  public abstract double execute(Object o) throws Exception;

  /**
   * @param parameters
   * @throws NotEnoughParametersException
   * Loads the parameters to be used in execution of the command
   */
  public void loadParameters(ArrayList<Double> parameters)
      throws NotEnoughParametersException {
    if (NUM_OF_PARAMETERS == parameters.size()) {
      this.parameters = parameters;
    } else {
      throw new NotEnoughParametersException();
    }
  }

}
