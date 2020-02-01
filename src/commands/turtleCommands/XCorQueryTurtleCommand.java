package commands.turtleCommands;

import backend.WorldModel; import backend.WorldsCollection;

import commands.TurtleCommand;

public class XCorQueryTurtleCommand extends TurtleCommand {

  public XCorQueryTurtleCommand() {
    super(0);
  }

  @Override
  public double execute(Object o) {
    WorldModel t = WorldsCollection.getCurrentWorld();
    return t.getActiveTurtles().get(0).getPosition().x;
  }

}
