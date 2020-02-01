package commands.mathCommands;

import commands.MathCommand;

public class ATanMathCommand extends MathCommand {

  public ATanMathCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) {
    return Math.toDegrees(Math.atan(parameters.get(0)));
  }

}
