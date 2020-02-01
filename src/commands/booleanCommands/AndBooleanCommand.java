package commands.booleanCommands;



public class AndBooleanCommand extends BooleanCommand {

  public AndBooleanCommand() {
    super(2);
  }

  @Override
  public double execute(Object o) {
    double test1 = parameters.get(0);
    double test2 = parameters.get(1);
    boolean result = (test1 != 0) & (test2 != 0);

    return booltoDouble(result);
  }

}
