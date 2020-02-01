package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandFactory {
  public ResourceBundle myCommands;

  public Map<String, Command> commandsUsed;



  private static final String DEFAULT_RESOURCE_PACKAGE = "util/";
  private String language;



  /**
   * Makes a HashMap of the command name to its respective action
   */
  public CommandFactory() {

    commandsUsed = new HashMap<String, Command>();
    myCommands= ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Command");
  }

  /**
   * @param translatedCommand
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws ClassNotFoundException
   * Uses reflection to create new commands
   */
  public Command createCommand(String translatedCommand) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    Command newCommand;

    if (commandsUsed.keySet().contains(translatedCommand) ) {
      newCommand = commandsUsed.get(translatedCommand);
      return newCommand;
    } else {
      newCommand = (Command) Class.forName(myCommands.getString(translatedCommand))
          .newInstance();
      commandsUsed.put(translatedCommand, newCommand);
      return newCommand;
    }
  }
}
