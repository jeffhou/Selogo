package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;

public class ForAdvancedCommand extends AdvancedCommand {

  public ForAdvancedCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) throws Exception {
    Interpreter interpreter = (Interpreter) o;
    try{
      ArrayList<String> variableAndLimit = interpreter.readBrackets();
      String variable = variableAndLimit.get(0).substring(1);
      int start = Integer.parseInt(variableAndLimit.get(1));
      int end = Integer.parseInt(variableAndLimit.get(2));
      int increment = Integer.parseInt(variableAndLimit.get(3));
      ArrayList<String> commandList = interpreter.readBrackets();
      for(int i = start; i < end; i+=increment) {
        interpreter.addVariable(variable, i);
        interpreter.addCommandToQueue(commandList);
      }
    }
    catch (Exception e) {
      throw new InvalidSyntaxException();
    }
    return 0;
  }

}
