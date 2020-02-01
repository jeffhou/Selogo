package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class ShowingQueryTurtleCommand extends TurtleCommand {

  public ShowingQueryTurtleCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.getActiveTurtles().get(0).isVisible ? 1 : 0;
  }

}
