package commands.mathCommands;

import commands.MathCommand;

public class TanMathCommand extends MathCommand {
  public TanMathCommand() {

    super(1);
  }

  @Override
  public double execute(Object o) {
    double expr = parameters.get(0);
    if (expr == Math.PI / 2) {
      return 0;
    }
    return Math.tan(Math.toRadians(expr));
  }

}
