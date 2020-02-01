package commands.mathCommands;

import commands.MathCommand;

public class QuotientMathCommand extends MathCommand {

  public QuotientMathCommand() {
    super(2);
  }

  @Override
  public double execute(Object o) {
    if(parameters.get(1).equals(Double.valueOf(0))) {
      return 0;
    }
    return parameters.get(0) / parameters.get(1);
  }

}
