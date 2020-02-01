package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class ClearScreenTurtleCommand extends TurtleCommand {

  public ClearScreenTurtleCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.clear();
  }

}
