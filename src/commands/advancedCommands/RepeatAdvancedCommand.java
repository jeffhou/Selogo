package commands.advancedCommands;

import java.util.ArrayList;

import util.StringOps;
import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;
import exceptions.NotEnoughParametersException;
import exceptions.SlogoException;


public class RepeatAdvancedCommand extends AdvancedCommand {

  public RepeatAdvancedCommand() {
    super(1);
  }

  @Override
  public double execute(Object o) throws Exception {
    int multiple = parameters.get(0).intValue();
    Interpreter interpreter = (Interpreter) o;
    ArrayList<String> bracketContents = interpreter.readBrackets();

    for(int i = 0; i < multiple; i++) {
      interpreter.addCommandToQueue(bracketContents);
    }
    return 0;
  }
}
