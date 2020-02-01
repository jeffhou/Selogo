package commands.booleanCommands;

import commands.Command;

public abstract class BooleanCommand extends Command {

  protected BooleanCommand(int numberOfParameters) {
    super(numberOfParameters, "boolean");
  }

  protected double booltoDouble(boolean b) {
    return b ? 1 : 0;
  }

}
