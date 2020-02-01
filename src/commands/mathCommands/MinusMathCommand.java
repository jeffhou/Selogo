package commands.mathCommands;

import commands.MathCommand;

public class MinusMathCommand extends MathCommand {

  public MinusMathCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {

    return -parameters.get(0);
  }

}
