package commands.advancedCommands;

import java.util.ArrayList;

import backend.Interpreter;
import commands.AdvancedCommand;
import exceptions.InvalidSyntaxException;

public class DoTimesAdvancedCommand extends AdvancedCommand {

  public DoTimesAdvancedCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) throws Exception {
    Interpreter interpreter = (Interpreter) o;
    ArrayList<String> variableAndLimit = interpreter.readBrackets();
    String variable = variableAndLimit.get(0).substring(1);
    try {
      int limit = Integer.parseInt(variableAndLimit.get(1));
      System.out.println(variable + "\n" + limit);
      ArrayList<String> commandList = interpreter.readBrackets();
      System.out.println(commandList.toString());
      for (int i = 0; i < limit; i++) {
        interpreter.addVariable(variable, i);
        interpreter.addCommandToQueue(commandList);
      }
    } catch (Exception e) {
      throw new InvalidSyntaxException();
    }
    return 0;
  }

}
